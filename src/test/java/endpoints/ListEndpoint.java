package endpoints;

public enum ListEndpoint implements Endpoint {
    CREATE_LIST("lists"),
    GET_LIST("lists/{id}"),
    ARCHIVE_LIST("lists/{id}/closed?value=true");


    private String endpoint;

    ListEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public String getEndPoint() {
        return endpoint;
    }
}
