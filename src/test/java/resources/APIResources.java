package resources;

public enum APIResources {

    CreateUserAPI("/v1/users"),
    getUserAPI("/v1/users");
    private String resource;

    APIResources(String resource)
    {
        this.resource=resource;
    }

    public String getResource()
    {
        return resource;
    }
}
