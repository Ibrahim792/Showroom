package CoreJava_project;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

class Showroom {
        private int vehicle_number;
        private String vehicle_name;
        private String owner_name;
        
    public int getVehicle_number() {
            return vehicle_number;
        }

        public String getVehicle_name() {
            return vehicle_name;
        }
        public String getOwner_name() {
            return owner_name;
        }

    Showroom(int vehicle_number, String vehicle_name, String owner_name) {
        this.vehicle_number= vehicle_number;
        this.vehicle_name = vehicle_name;
        this.owner_name = owner_name;
    }

    public String toString(){
            return "Vehicle Number:" +vehicle_number+  " Vehicle Name:"+vehicle_name+  " Owner Name:"+owner_name;
        }
    }

 class CRUDoperation{
      public static void main(String[] args) {
        
         List <Showroom> s = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        
        int run;
        do{        
        System.out.println("1.INSERT VEHICLE DETAILS");
        System.out.println("2.DISPLAY VEHICLE DETAILS");
        System.out.println("3.SEARCH VEHICLE DETAILS");
        System.out.println("4.UPDATE VEHICLE DETAILS");
        System.out.println("5.DELETE VEHICLE DETAILS");
        
        System.out.print("Enter Your Choice :");
        run = sc.nextInt();        
        
        switch (run) {
            case 1: System.out.print("Enter Vehicle Number :");
                    int vehicle_number = sc.nextInt();

                    System.out.print("Enter Owner Name :");
                    String owner_name = sc.next();

                    System.out.print("Enter Vehicle Name :");
                    String vehicle_name = sc.next();

                 s.add(new Showroom(vehicle_number,vehicle_name,owner_name));
            break;
            
            case 2 :  
                System.out.println("------------------------------------------------------------");
                Iterator  <Showroom> ite = s.iterator();
                while(ite.hasNext()){
                Showroom shw = ite.next();
                System.out.println(shw);
                }
                System.out.println("------------------------------------------------------------");
             break;
            
             case 3 :
                boolean found = false;
                System.out.println("Enter Vehicle Number To Search: ");
                vehicle_number = sc.nextInt();
                System.out.println("------------------------------------------------------------");
                    ite = s.iterator();
                    while (ite.hasNext()){
                            Showroom shw = ite.next();
                            if (shw.getVehicle_number() == vehicle_number ){
                                System.out.println(shw);
                                found = true;
                            }
                    }
                    if (!found){
                        System.out.println("No Records found");
                    }
                System.out.println("------------------------------------------------------------");
            break;
           
            case 4 :
                found = false;
                System.out.println("Enter Vehicle Number To Update details: ");
                vehicle_number = sc.nextInt();
                System.out.println("------------------------------------------------------------");
                ListIterator <Showroom> list = s.listIterator();
                    while (list.hasNext()){
                            Showroom shw = list.next();
                            if (shw.getVehicle_number() == vehicle_number ){

                                System.out.println("Enter new Owner Name :");
                                owner_name = sc.next();

                                System.out.println("Enter new vehicle name :");
                                vehicle_name = sc.next();

                                list.set(new Showroom(vehicle_number,vehicle_name,owner_name));
                                found = true;
                            }
                    }
                    if (!found){
                        System.out.println("No Records found");
                    }
                    else {
                        System.out.println("vehicle details Updated successfully");
                    }
                System.out.println("------------------------------------------------------------");
            break;
           
            case 5 :
                found = false;
                System.out.println("Enter Vehicle Number To Delete: ");
                vehicle_number = sc.nextInt();
                System.out.println("------------------------------------------------------------");
                    ite = s.iterator();
                    while (ite.hasNext()){
                            Showroom shw = ite.next();
                            if (shw.getVehicle_number() == vehicle_number ){
                                ite.remove();
                                System.out.println(shw);
                                found = true;
                            }
                    }
                    if (!found){
                        System.out.println("vehicle details not found");
                    }
                    else {
                        System.out.println("vehicle details deleted successfully");
                    }
                System.out.println("------------------------------------------------------------");
            break;

          }
       }
        while(run!=0);
      }  
 }