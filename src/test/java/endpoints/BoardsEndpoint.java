package endpoints;

public enum BoardsEndpoint implements Endpoint {
    GET_BOARD("boards/{id}"),
    CREATE_BOARD("boards");



    private String endPoint;

    BoardsEndpoint(String endPoint) {
        this.endPoint = endPoint;
    }

    @Override
    public String getEndPoint() {
        return this.endPoint;
    }
}
