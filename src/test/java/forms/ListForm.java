package forms;

import com.fasterxml.jackson.annotation.*;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ListForm extends BaseForm implements Ifrom {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("idBoard")
    private String idBoard;


    @JsonCreator
    public ListForm(@JsonProperty("name")String name, @JsonProperty("idBoard")String idBoard) {
        this.name = name;
        this.idBoard = idBoard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdBoard() {
        return idBoard;
    }

    public void setIdBoard(String idBoard) {
        this.idBoard = idBoard;
    }

    public String getId() {
        return id;
    }

    @JsonSetter
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListForm)) return false;
        ListForm listForm = (ListForm) o;
        return  Objects.equals(name, listForm.name) &&
                Objects.equals(idBoard, listForm.idBoard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, idBoard);
    }
}
