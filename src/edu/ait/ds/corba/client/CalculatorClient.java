package edu.ait.ds.corba.client;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import edu.ait.ds.corba.Calculator;
import edu.ait.ds.corba.CalculatorHelper;

/**
 * @author prabh
 *
 *start client
 *java edu.ait.ds.corba.client.CalculatorClient -ORBInitialPort 1050 -ORBInitialHost localhost
 */
public class CalculatorClient {
	public static void main(String args[]) {
        try {
            // create and initialize the ORB
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            Calculator calculator = CalculatorHelper.narrow(ncRef.resolve_str("Calc"));

            int hello = calculator.add(10,30);
            System.out.println(hello);
            int sub = calculator.subtract(50, 10);
            System.out.println(sub);
            int multiply = calculator.multiply(5, 75);
            System.out.println(multiply);
            int divide = calculator.divide(121, 11);
            System.out.println(divide);
        } catch (InvalidName invalidName) {
            invalidName.printStackTrace();
        } catch (CannotProceed cannotProceed) {
            cannotProceed.printStackTrace();
        } catch (org.omg.CosNaming.NamingContextPackage.InvalidName invalidName) {
            invalidName.printStackTrace();
        } catch (NotFound notFound) {
            notFound.printStackTrace();
        }

    }

}
