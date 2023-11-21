package api.endpoints;

/*
Base URl -----> https://petstore3.swagger.io/api/v3

Create User (Post) ----> https://petstore3.swagger.io/api/v3/user
Get User (Get) --------> https://petstore3.swagger.io/api/v3/user/{username}
Update User (Put)------> https://petstore3.swagger.io/api/v3/user/{username}
Delete User(Delete)----> https://petstore3.swagger.io/api/v3/user/{username}

*/


public class Routes {

    public static String base_url = "https://petstore3.swagger.io/api/v3";

    //user module
    public static String post_url = base_url + "/user";
    public static String get_url = base_url + "/user/{username}";
    public static String update_url = base_url + "/user/{username}";
    public static String delete_url = base_url + "/user/{username}";

}
