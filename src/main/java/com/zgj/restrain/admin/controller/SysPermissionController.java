package com.zgj.restrain.admin.controller;

import com.zgj.restrain.admin.model.SysPermission;
import com.zgj.restrain.admin.model.SysRole;
import com.zgj.restrain.admin.model.UserInfo;
import com.zgj.restrain.admin.service.SysPermissionService;
import com.zgj.restrain.admin.service.UserInfoService;
import com.zgj.restrain.admin.util.Node;
import com.zgj.restrain.admin.util.TreeList;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 2018/5/10.
 */
@RestController
@RequestMapping("/permission")
public class SysPermissionController {
    @Autowired
    private SysPermissionService sysPermissionService;

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/getPermission")
    public Map getPermission(){
        Map<String,Object> map = new HashMap<>();
        Integer userid = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userSessionId");
//        List<SysPermission> resourcesList = sysPermissionService.loadUserResources(userid);
    /*    for (SysPermission sysPermission : resourcesList){
            List<Map<String,Object>> childList = new ArrayList<Map<String, Object>>();
            Map<String,Object> map1 = new HashMap<String,Object>();
            map1.put("id",sysPermission.getId());
            map1.put("name",sysPermission.getName());
            map1.put("url",sysPermission.getUrl());
            map1.put("resourceLogo",sysPermission.getResourceLogo());
            map1.put("parentId",sysPermission.getParentId());
            map1.put("sort",sysPermission.getSort());
            childList.add(map1);
        }*/
        Node tree =getTreeJson(userid);
        map.put("data",tree);
        return map;
    }

    public Node getTreeJson(Integer userid){
        List<SysPermission> sysPermissions = sysPermissionService.loadUserResources(userid);
        List<Node> nodes = new ArrayList<Node>();//把所有资源转换成树模型的节点集合，此容器用于保存所有节点
        for (SysPermission sysPermission : sysPermissions){
            Node node = new Node();
            node.setHref(sysPermission.getUrl());
            node.setIcon(sysPermission.getResourceLogo());
            node.setNodeId(sysPermission.getId()+"");
            node.setPid(sysPermission.getParentId()+"");
            node.setText(sysPermission.getName());
            nodes.add(node);
        }
        Node tree = new Node();
        Node mt = tree.createTree(nodes);
        return mt;
    }

}
