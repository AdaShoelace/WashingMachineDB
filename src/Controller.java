/**
 * Created by Pierre on 2016-05-19.
 */
public class Controller {

    private InputManager im;

    public Controller() {
       InputManager.initiateConnection();
    }

    public static void main(String[] args) {
        Controller c = new Controller();
        GUI gui = new GUI();

    }
}
