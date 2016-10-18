import java.util.ArrayList;
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

public class Main
	{
		static double randomTimeChangeNumber = 0;
		static double normalTime = 0;
		static double randomTimeChange = 0;
		static boolean didWin = true;
		static int winLoose = 0;
		static int balance = 100;
		static int bet = 0; 
		static int racerBet = 0;
		static boolean stillPlay = true;
		static double racePer = 0;
		static ArrayList <Racer> race = new ArrayList <Racer>();
		public static void main(String[] args)
			{
				welcome();
				pojoSetUp();
				while(stillPlay)
					{
						bet();
						race();
					}
			}
		public static void welcome()
		{
			System.out.println("Welcome to the Air Race!");
		}
		public static void pojoSetUp()
		{
			race.add(new Racer("Hannes Arch","Austria","Edge 540 V3", 41));
			race.add(new Racer("Cristian Bolton","Chile","Edge 540 V2", 0));
			race.add(new Racer("Kirby Chambliss","U.S.","Edge 540 V3", 30));
			race.add(new Racer("Matthias Dolderer","Germany","Edge 540 V3", 80));
			race.add(new Racer("Michael Goulian","U.S.","Edge 540 V2", 20));
			race.add(new Racer("Matt Hall","Australia","MXS", 56));
			race.add(new Racer("Nicolas Ivanoff","France","Edge 540 V2", 35));
			race.add(new Racer("Petr Kopfstein","Czech Republic","Edge 540 V3", 4));
			race.add(new Racer("Nigel Lamb","Britain","MXS-R", 38));
			race.add(new Racer("Francios Le Vot","France","Edge 540 V2", 10));
			race.add(new Racer("Pete Mcleod","Canada","Edge 540 V3", 31));
			race.add(new Racer("Yoshihide Muroya","Japan","Edge 540 V3", 32));
			race.add(new Racer("Peter Podlunsek","Slovenia","Edge 540 V2", 4));
			race.add(new Racer("Martin Sonka","Czech Republic","Edge 540 V3", 31));
			race.add(new Racer("Juan Velarde","Spain","Edge 540 V2", 14));
		}
		public static void bet()
		{
			restartEverything();
			System.out.println("Your balance is "+balance+"! Who do you want to bet on?");
			System.out.println("");
			System.out.println("1. Hannes Arch");
			System.out.println("2. Cristian Bolton");
			System.out.println("3. Kirby Chambliss");
			System.out.println("4. Matthias Dolderer");
			System.out.println("5. Michael Goulian");
			System.out.println("6. Matt Hall");
			System.out.println("7. Nicolas Ivanoff");
			System.out.println("8. Patr Kopfstein");
			System.out.println("9. Nigel Lamb");
			System.out.println("10. Francios Le Vot");
			System.out.println("11. Pete Mcleod");
			System.out.println("12. Toshihide Muroya");
			System.out.println("13. Peter Pudlunsek");
			System.out.println("14. Martin Sonka");
			System.out.println("15. Juan Velarde");
			System.out.println("");
			Scanner userInput = new Scanner(System.in);
			racerBet = userInput.nextInt();
			if(racerBet > 15)
				{
					System.out.println("Thats to high!");
					System.exit(0);
				}
			else if(racerBet < 1)
				{
					System.out.println("Thats to low!");
					System.exit(0);
				}
			System.out.println("");
			System.out.println("How much do you want to bet?");
			Scanner userInput1 = new Scanner(System.in);
			bet = userInput1.nextInt();
			if(bet < 0)
				{
					System.out.println("No negatives!");
					System.exit(0);
				}
			else if(bet > balance)
				{
					System.out.println("You dont have that much money!");
					System.exit(0);
				}
			System.out.println("You bet "+bet+" on "+race.get(racerBet-1).getName()+"!");
		}
		public static void race()
		{
			double racerWinCent = race.get(racerBet-1).getPoint();
			System.out.println("The race has started!");
			racePer = racerWinCent / 426;
			racePer = racePer * 100;
			System.out.println("There is a "+racePer+"% of your racer winning!");
			normalTime = racePer;
			racePer = racePer + randomChange(racePer);
			ifRacePer();
			System.out.println("Their win percentage went up to "+racePer+"!");
			System.out.println("The race is over!");
			if(winOrLoose(didWin)==true)
				{
					System.out.println("Your racer won!");
					afterRace();
					playAgain();
				}
			else if(winOrLoose(didWin)==false)
				{
					System.out.println("Your racer lost!");
					afterRace();
					playAgain();
				}
		}
		public static boolean winOrLoose(boolean w)
		{
			double c = racePer;
			double b = (double)(Math.random()*100);
			if(b < c)
				{
					didWin = true;
				}
			else if(b > c)
				{
					didWin = false;
				}
			return didWin;
		}
		public static void afterRace()
		{
			if(didWin==true)
				{
					System.out.println("");
					balance = balance + bet;
				}
			else if(didWin==false)
				{
					System.out.println("");
					balance = balance - bet;
				}
		}
		public static void playAgain()
		{
			if(balance==0)
				{
					System.out.println("Sorry you ran out of money!");
					stillPlay = false;
					System.exit(0);
				}
			else if(balance < 0)
				{
					System.out.println("I dont even know how you did that.");
					stillPlay = false;
				}
			System.out.println("Your new balance is "+balance+"!");
			System.out.println("Do you want to play again?");
			System.out.println("1. Yes");
			System.out.println("2. No");
			Scanner userInput2 = new Scanner(System.in);
			int playAgain = userInput2.nextInt();
			if(playAgain==1)
				{
					stillPlay = true;
				}
			else if(playAgain==2)
				{
					stillPlay = false;
				}
		}
		public static double randomChange(double a)
		{
			double b = (double)(Math.random()*100);
			randomTimeChangeNumber = b;
			b = b * 0.1;
			a = a + b;
			return a;
		}
		public static void ifRacePer()
		{
			if(randomTimeChangeNumber==50)
				{
					System.out.println("Your racer is doing terrible!");
					racePer = -10;
				}
			else if(randomTimeChangeNumber > 100)
				{
					System.out.println("Your racer is doing amazing today!");
				}
			else if(randomTimeChangeNumber > 75)
				{
					System.out.println("Your racer is doing way better then normal! today!");
				}
			else if(randomTimeChangeNumber > 40)
				{
					System.out.println("Your racer is doing better than normal today!");
				}
			else if(randomTimeChangeNumber > 20)
				{
					System.out.println("Your racer is doing a little better than normal today!");
				}
			else if(randomTimeChangeNumber > 10)
				{
					System.out.println("Your racer is doing ok today!");
				}
			else if(randomTimeChangeNumber==0)
				{
					System.out.println("Your racer is doing normal today!");
				}
		}
		public static void restartEverything()
		{
			normalTime = 0;
			randomTimeChange = 0;
			didWin = true;
			winLoose = 0;
			racerBet = 0;
			bet = 0;
			racePer = 0;
			stillPlay = true;
			randomTimeChangeNumber = 0;
		}
	}