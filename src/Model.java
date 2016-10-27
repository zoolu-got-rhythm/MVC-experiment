import java.util.ArrayList;
import java.util.Collection;

// the model is observable but doesn't need to know anything about any other class(it's state is completely seperate)
class Model{
    private String state; // whatever the current state
    private ArrayList<String> bunchOfState = new ArrayList<>(); // a collection of all the different state

    private ArrayList<View> observers = new ArrayList<>(); // subscribed observers of this class

    // Model(){}

    public String getState() {
        return state;
    }

    public void setState(String input) {
        this.state = input;
        this.colletStuff(this.state);
    }

    // can you convert any type to a string? this generic method is experimental and currently i'm -
    // only parsing in a string type from the Scanner.next() as Scanner doesn't accept generic types to my knowledge.
    private <T> void colletStuff(T thing){
        try{
            String covertedType = (String) thing;
            this.bunchOfState.add(covertedType);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String getBunch(){
        String gather = "";
        for(int i = 0; i < bunchOfState.size(); i++){
            gather += bunchOfState.get(i);
        }
        return gather;
    }

    public void addObserver(View v){
        // loop through all observers and update;
        observers.add(v);
    }

    public void notifyObservers(){
        // notify all objects that are watching our state
        for(int i = 0; i < observers.size(); i++){
            observers.get(i).notifi();
        }
    }
}