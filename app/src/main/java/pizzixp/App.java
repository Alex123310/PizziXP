/*
* This Java source file was generated by the Gradle 'init' task.
*/
package pizzixp;
//Usually you will require both swing and awt packages
// even if you are working with just swings.
import java.util.Scanner;
import java.awt.Toolkit;
class App
{
    public static void main(String args[]) 
    {
        var input = new Scanner(System.in);
        int scelta = 0;
        while (scelta == 0)
        {
            System.out.println("Scegli il tipo di interfaccia grafica da utilizzare:");
            scelta = Integer.parseInt(input.nextLine());
            input.close();
            if (scelta == 1)
            {
                new JavaSwingGui();
                break;
            }
            if(scelta == 2)
            {
                new awtgui();
                break;
            }
            else
            {
                System.out.println("Scelta non valida, riprova");
                
                scelta = 0;
            }
        }
        System.out.println(Toolkit.getDefaultToolkit().getScreenSize());
        Toolkit.getDefaultToolkit().beep();
    }

}
