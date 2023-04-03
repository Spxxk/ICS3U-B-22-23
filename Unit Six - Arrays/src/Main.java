import java.util.Scanner;
public class Main {
     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int delivered = sc.nextInt();  
//         int collisions = sc.nextInt(); 
//         int totalPoints = 0;
   

//     if (delivered > collisions) {
//         totalPoints = 500;
//     }
//     totalPoints = totalPoints + delivered * 50;
//     totalPoints = totalPoints - collisions * 10;
//     System.out.println(totalPoints);  
//   }
// }

int TSHU = 0;
    Scanner sc = new Scanner(System.in);
        int Pepnum = sc.nextInt();
        for (int i = 0; i < Pepnum; i++) {
            String Peppers = sc.nextLine();
        }
         String Peppers = sc.nextLine();

         int P = 1500;
         int M = 6000;
         int S = 15500;
         int C = 40000;
         int T = 75000;
         int H = 125000;
        

        for (int i = 0; i < Pepnum; i++) {
            if(Peppers.substring(i).equals("Poblano"))
                TSHU += P;
            
            else if(Peppers.substring(i).equals("Mirasol"))
                TSHU += M;
            
            else if(Peppers.substring(i).equals("Serrano"))
                TSHU += S;
            
            else if(Peppers.substring(i).equals("Cayenne"))
                TSHU += C;
            
            else if(Peppers.substring(i).equals("Thai"))
                TSHU += T;
            
            else if(Peppers.substring(i).equals("Habanero"))
                TSHU += H;
            
        }
        System.out.println(TSHU);
    } 
}
        

// Scanner sc = new Scanner(System.in);
//         int days = sc.nextInt();
//         for (int i = 0; i < days; i++) {
//             String person = sc.nextLine();
//         }
//          String person = sc.nextLine();


// int d1c = 0;
// int d2c = 0;
// int d3c = 0;
// int d4c = 0;
// int d5c = 0;

// for (int i = 0; i < 1; i++) {
// if(person.substring(0).equals("Y...."))
//     d1c++;

// else if(person.substring(0).equals(".Y..."))
//     d2c++;

// else if(person.substring(0).equals("..Y.."))
//     d3c++;

// else if(person.substring(0).equals("...Y."))
//     d4c++;

// else if(person.substring(0).equals("....Y"))
//     d5c++;
// }

// for (int i = 0; i < 1; i++) {
//     if(person.substring(0).equals("YY...")){
//         d1c++;
//         d2c++;
//     }
    

//     else if(person.substring(0).equals("YYY..")){
//         d1c++;
//         d2c++;
//         d3c++;
//     }

//     else if(person.substring(0).equals("YYYY.")){
//         d1c++;
//         d2c++;
//         d3c++;
//         d4c++;
//     }

//     else if(person.substring(0).equals("YYYYY")){
//         d1c++;
//         d2c++;
//         d3c++;
//         d4c++;
//         d5c++;
//     }





//     else if(person.substring(0).equals("Y.Y.."))
//         d5c++;
//     }

//     for (int i = 0; i < 1; i++) {
//         if(person.substring(0).equals("Y..Y."))
//             d1c++;

//         else if(person.substring(0).equals("Y...Y"))
//             d2c++;

//         else if(person.substring(0).equals(".YY.."))
//             d3c++;

//         else if(person.substring(0).equals(".Y.Y."))
//             d4c++;

//         else if(person.substring(0).equals(".Y..Y"))
//             d5c++;
//         }

//         for (int i = 0; i < 1; i++) {
//             if(person.substring(0).equals("..YY."))
//                 d1c++;
    
//             else if(person.substring(0).equals("..Y.Y"))
//                 d2c++;
    
//             else if(person.substring(0).equals("...YY"))
//                 d3c++;
//             }

//             for (int i = 0; i < 1; i++) {
//                 if(person.substring(0).equals(".YYYY")){
//                     d4c++;
//                     d2c++;
//                     d3c++;
//                     d5c++;

//                 }
        
//                 else if(person.substring(0).equals("..YYY")){
//                     d3c++;
//                     d4c++;
//                     d5c++;
//                 }
        
//                 else if(person.substring(0).equals("...YY")){
//                     d4c++; 
//                     d5c++;
//                 }

//                     else if(person.substring(0).equals("...Y"))
//                     d5c++;

        
//                 }
//                 for (int i = 0; i < 1; i++) {
//                     if(person.substring(0).equals("YY.Y.")){
//                         d1c++;
//                         d2c++;
//                         d4c++;
//                     }
                    
//                     else if(person.substring(0).equals(".YYY.")){
//                         d2c++;
//                         d3c++;
//                         d4c++;
//                     }
                        
                    
//                     else if(person.substring(0).equals("YY..Y")){
//                         d1c++;
//                         d2c++;
//                         d5c++;
//                     }
                    
//                     else if(person.substring(0).equals(".YY.Y")){
//                         d2c++;
//                         d3c++;
//                         d5c++;
//                     }
                        
                    
                
//                     }

           




// if(d1c > d2c && d1c > d3c && d1c > d4c && d1c > d5c){
//     System.out.print("1");
// }
// else if(d2c > d1c && d2c > d3c && d2c > d4c && d2c > d5c){
//     System.out.print("2");
// }
// else if(d3c > d1c && d3c > d2c && d3c > d4c && d3c > d5c){
//     System.out.print("3");
// }
// else if(d4c > d1c && d4c > d2c && d4c > d3c && d4c > d5c){
//     System.out.print("4");
// }
// else if(d5c > d1c && d5c > d2c && d5c > d4c && d5c > d4c){
//     System.out.print("5");
// }
// else if(d1c == d2c)
//     System.out.print("1 " + "2");
// else if(d1c == d3c)
//     System.out.print("1 " + "3");
// else if(d1c == d4c)
//     System.out.print("1 " + "4");   
// else if(d1c == d5c)
//     System.out.print("1 " + "5"); 


// else if(d2c == d3c)
//     System.out.print("2 " + "3");
// else if(d2c == d4c)
//     System.out.print("2 " + "4");   
// else if(d2c == d5c)
//     System.out.print("2 " + "5"); 

// else if(d3c == d4c)
//     System.out.print("3 " + "4");   
// else if(d3c == d5c)
//     System.out.print("3 " + "5"); 


// else if(d4c == d5c)
//     System.out.print("4 " + "5"); 

    




// }
// }





