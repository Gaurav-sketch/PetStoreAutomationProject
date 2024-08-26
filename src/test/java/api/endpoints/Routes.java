package api.endpoints;

/*
CreateUser : "https://petstore.swagger.io/v2/user"
getUser :   "https://petstore.swagger.io/v2/user/{username}"
updateUser : "https://petstore.swagger.io/v2/user/{username}"
deleteUser : "https://petstore.swagger.io/v2/user/{username}"
*/


public class Routes {

    public static String base_url= "https://petstore.swagger.io/v2";

    //User Module
    public static String post_url = base_url+"/user";
    public static String get_url= base_url+ "/user/{username}";
    public static String update_url= base_url+ "/user/{username}";
    public static String delete_url= base_url+ "/user/{username}";

}
