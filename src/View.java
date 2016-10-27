import java.util.Observer;
import java.util.Scanner;

// View is an observer to the model(observable)
// all views should implement notifi
class View implements ObserverPattern{
    private Model model;

    View(Model model){this.model = model;}

    // each view contains it's own implementation of notifi
    public void notifi(){
        System.out.println(this.model.getClass().toString());
        System.out.println(this.model.getState());
        System.out.println(this.model.getBunch());
    }
}