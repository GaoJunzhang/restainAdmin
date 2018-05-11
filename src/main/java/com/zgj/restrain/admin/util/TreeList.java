package com.zgj.restrain.admin.util;

import com.zgj.restrain.admin.model.SysPermission;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 2018/5/10.
 */
public class TreeList {
    private List<SysPermission> resultNodes = new ArrayList<SysPermission>();//树形结构排序之后list内容
    private List<SysPermission> nodes; //传入list参数
    public TreeList(List<SysPermission> nodes) {//通过构造函数初始化
        this.nodes = nodes;
    }
    private List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
    /**
     * 构建树形结构list
     * @return 返回树形结构List列表
     */
    public List<SysPermission> buildTree() {
        for (SysPermission node : nodes) {
            String id = node.getId().toString();
            if (node.getParentId() == 0) {//通过循环一级节点 就可以通过递归获取二级以下节点
                Map<String, Object> m = new HashMap<String, Object>();
                m.put("id",node.getId());
                resultNodes.add(node);//添加一级节点
                build(node);//递归获取二级、三级、。。。节点
            }
        }
        return resultNodes;
    }
    /**
     * 递归循环子节点
     *
     * @param node 当前节点
     */
    private void build(SysPermission node) {
        List<SysPermission> children = getChildren(node);
        if (!children.isEmpty()) {//如果存在子节点
            for (SysPermission child : children) {//将子节点遍历加入返回值中
                Map<String, Object> m = new HashMap<String, Object>();
                m.put("children",child);
                list.add(m);
                resultNodes.add(child);
                build(child);
            }
        }
    }
    /**
     * @param node
     * @return 返回
     */
    private List<SysPermission> getChildren(SysPermission node) {
        List<SysPermission> children = new ArrayList<SysPermission>();
        String id = node.getId().toString();
        for (SysPermission child : nodes) {
            System.out.println(id+"========"+child.getParentId());
            if (id.equals(child.getParentId().toString())) {//如果id等于父id
                System.out.println("success");
                children.add(child);//将该节点加入循环列表中
            }
        }
        return children;
    }
}
