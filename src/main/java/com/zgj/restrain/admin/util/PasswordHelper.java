package com.zgj.restrain.admin.util;


import com.zgj.restrain.admin.model.UserInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class PasswordHelper {
	//private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	private String algorithmName = "md5";
	private int hashIterations = 2;

	public void encryptPassword(UserInfo user) {
		//String salt=randomNumberGenerator.nextBytes().toHex();
		String newPassword = new SimpleHash(algorithmName, user.getPassword(),  ByteSource.Util.bytes(user.getUsername()+"3ef7164d1f6167cb9f2658c07d3c2f0a"), hashIterations).toHex();
		//String newPassword = new SimpleHash(algorithmName, user.getPassword()).toHex();
		user.setPassword(newPassword);

	}

	public  String getPassword(UserInfo user){
		String newPassword = new SimpleHash(algorithmName, user.getPassword(),  ByteSource.Util.bytes(user.getUsername()), hashIterations).toHex();
		//String newPassword = new SimpleHash(algorithmName, user.getPassword()).toHex();
		user.setPassword(newPassword);

		return user.getPassword();
    }

	public static void main(String[] args) {
		PasswordHelper passwordHelper = new PasswordHelper();
		UserInfo user = new UserInfo();
		user.setUsername("admin");
			user.setPassword("admin");
		passwordHelper.encryptPassword(user);
		System.out.println(user.getPassword());
//        System.out.print(passwordHelper.getPassword("888888"));
	}
}
