

public abstract class Sequence {
    private String description = "";
    private String content = "";
    
    Sequence(String description, String content){
        this.description = description;
        this.content = content;
    }
    
    public String getDescription(){
        return description;
    }
    
    public String getContent(){
        return content;
    }
}
