package Junit;

public class User {
    public String loginName(String loginName, String passWord){
        if("admin".equals(loginName) && "123456".equals(passWord) ){
            return "Login Successful";
        }else {
            return "Incorrect Username or Password";
        }
    }

    public void selectName(){
        System.out.println(10/1);
        System.out.println("Lookup the username successfully");
    }
}
