import javax.xml.stream.events.EndDocument;
import java.lang.reflect.GenericDeclaration;

public class Vehicle {
    DriveStrategy driveStrategy;
    EngineType engine;

    Vehicle(DriveStrategy driveStrategy, EngineType engine){

        this.driveStrategy = driveStrategy;
        this.engine = engine;
    }

    void drive(){
        driveStrategy.drive();
    }

    void enginePower(){
        engine.enginePower();
    }
}
