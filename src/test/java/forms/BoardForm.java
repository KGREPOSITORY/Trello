package forms;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.Objects;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonDeserialize(builder = BoardForm.Builder.class)
public class BoardForm extends BaseForm implements Ifrom {
    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    private String id;

    @JsonProperty("defaultLabels")
    private boolean defaultLables;

    @JsonProperty("defaultLists")
    private boolean defaultLists;

    @JsonProperty("desc")
    private String description;


    @JsonPOJOBuilder(buildMethodName = "create", withPrefix = "set")
    public static class Builder{
        private BoardForm boardForm;

        public Builder(){
            boardForm = new BoardForm();
        }

        public Builder withName(String name){
            boardForm.name = name;
            return this;
        }

        public Builder withDefaultLables(Boolean isDefault){
            boardForm.defaultLables = isDefault;
            return this;
        }

        public Builder withDefaultLists(Boolean isDefault){
            boardForm.defaultLists = isDefault;
            return this;
        }

        public Builder withDescription(String description){
            boardForm.description = description;
            return this;
        }

        public BoardForm build(){
            return this.boardForm;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BoardForm)) return false;
        BoardForm boardForm = (BoardForm) o;
        return defaultLables == boardForm.defaultLables &&
                defaultLists == boardForm.defaultLists &&
                Objects.equals(name, boardForm.name) &&
                Objects.equals(id, boardForm.id) &&
                Objects.equals(description, boardForm.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, id, defaultLables, defaultLists, description);
    }
}
