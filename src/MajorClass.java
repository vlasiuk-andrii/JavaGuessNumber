import java.util.Scanner;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MajorClass {

        public static void main( String args[] )
        {
            Scanner input = new Scanner( System.in );

            int number;
            int limit = 100;
            int min = 0;
            int max = limit;
            int iteration = 0;

            System.out.print( "Hello! I've set a number. Try to guess it! :)\n" );

            String s = null;
            Pattern p = Pattern.compile("^\\d+$");
            Matcher l = null;

            do  { System.out.print( "Please enter number[0..100]: " );
            s = input.nextLine();
            l = p.matcher(s);
                } while (!l.matches());
            number = Integer.parseInt(s);

            if ((number < 0) | (number > limit)){
                do  { System.out.print( "Please enter number[0..100]: " );
                    s = input.nextLine();
                    l = p.matcher(s);
                } while (!l.matches());
                number = Integer.parseInt(s);
            }

            Random rand = new Random();
            int randomNum = rand.nextInt(limit);

            while (true) {
                iteration++;

                if (number == randomNum) {
                    System.out.println();
                    System.out.println("Congratulations! You guessed the randomNumber!");
                    break;
                }

                if ((number < randomNum) & (number >= 0)) {
                    min = number + 1;
                    System.out.println();
                    System.out.println("Your number is SMALLER then my randomNumber");
                    do{ System.out.print( "Please enter your number ones more["+min+".."+max+"]:" );
                        s = input.nextLine();
                        l = p.matcher(s);
                    } while (!l.matches());
                    number = Integer.parseInt(s);
                    continue;
                }

                if ((number > randomNum) & (number <= limit)) {
                    max = number - 1;
                    System.out.println();
                    System.out.println("Your number is BIGGER then my randomNumber");
                    do{ System.out.print( "Please enter your number ones more["+min+".."+max+"]:" );
                        s = input.nextLine();
                        l = p.matcher(s);
                    } while (!l.matches());
                    number = Integer.parseInt(s);
                    continue;
                }

                else {
                    do{ System.out.print( "Incorrect input. ");
                        System.out.print( "Please enter your number ones more["+min+".."+max+"]:" );
                        s = input.nextLine();
                        l = p.matcher(s);
                    } while (!l.matches());
                    number = Integer.parseInt(s);
                }
            }

            System.out.printf( "Your number = %d\n", number );
            System.out.printf( "My randomNumber = %d\n\n", randomNum );
            System.out.printf( "Your result = %d ", iteration);
            System.out.printf( "attempts\n");

        }

}
