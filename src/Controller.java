import java.util.Scanner;

class Controller{
    private View v;
    private Model m;
    Controller(){
        // initialize and glue components together
        this.m = new Model();
        this.v = new View(this.m);
        this.m.addObserver(this.v); // try adding multiple observers(views) intererations(visuals) of data to user.

        while(true){
            m.notifyObservers(); // update all views(observers) subscribed to model(observable).
            Scanner userInput = new Scanner(System.in); // capture user input
            m.setState(userInput.next()); // manipulate state in model
        }
    }
}