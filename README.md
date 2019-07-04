# MultilevelParking
I have developed the solution as a command line runnable jar.
Below are some test scenarios I went through.
It can support any number of floors. 
You can start by going to the target directory and write below command in command line:
    java -jar MinasTirithParkingSystem-jar-with-dependencies.jar

Some of the abbrevations used :
  NF = Not filled
  P = Empty parking slot.
  Slot number - Ex: 1020
                    Here, 1 denotes floor number
                          0,2 denotes the co-ordinates in 6x5 matrix laid down as entire floor.
                          
                          For Cars, 0 = Upper slot
                                    1 = Lower slot
                                    
                          For Bikes, 0-1 = Upper slot
                                     2-4 = Lower slot
   
                          


java -jar MinasTirithParkingSystem-jar-with-dependencies.jar
Welcome to Minas Tirith Central Parking
*********************************************************************************
Application Setup START...
Enter number of floor:
2
Setting up parking for 2 floors
How many slots out of 20 you want to be configured for Cars for floor number 1? :
12
How many slots out of 20 you want to be configured for Cars for floor number 2? :
14
Application Setup END...
*********************************************************************************
Current parking status for Floor #1
[P, P, P, P, P]
[-, -, -, -, -]
[P, P, P, P, P]
[P, P, P, P, P]
[-, -, -, -, -]
[P, P, P, P, P]
Current parking status for Floor #2
[P, P, P, P, P]
[-, -, -, -, -]
[P, P, P, P, P]
[P, P, P, P, P]
[-, -, -, -, -]
[P, P, P, P, P]
Vehicle Outgoing or Incoming?
 1. Incoming 2. Outgoing
1
Which type of vehicle ?
 1.Car or 2.Bike?
1
Enter number of passengers :
5
Enter Registration number :
SD12-1233
Driven by elderly ?
  Y or N
Y
Driven by royal family ?
 Y or N
Y
0 1
Slot number allotted : 1000
Current parking status for Floor #1
[Upper slot : SD12-1233  NF , F, P, P, P]  
[-, -, -, -, -]
[P, P, P, P, P]
[P, P, P, P, P]
[-, -, -, -, -]
[P, P, P, P, P]
Current parking status for Floor #2
[P, P, P, P, P]
[-, -, -, -, -]
[P, P, P, P, P]
[P, P, P, P, P]
[-, -, -, -, -]
[P, P, P, P, P]
Vehicle Outgoing or Incoming?
 1. Incoming 2. Outgoing
1
Which type of vehicle ?
 1.Car or 2.Bike?
1
Enter number of passengers :
4
Enter Registration number :
AS53542
Driven by elderly ?
  Y or N
Y
Driven by royal family ?
 Y or N
N
Slot number allotted : 1020
Current parking status for Floor #1
[Upper slot : SD12-1233  NF , F, Upper slot : AS53542  NF , P, P]
[-, -, -, -, -]
[P, P, P, P, P]
[P, P, P, P, P]
[-, -, -, -, -]
[P, P, P, P, P]
Current parking status for Floor #2
[P, P, P, P, P]
[-, -, -, -, -]
[P, P, P, P, P]
[P, P, P, P, P]
[-, -, -, -, -]
[P, P, P, P, P]
Vehicle Outgoing or Incoming?
 1. Incoming 2. Outgoing
1
Which type of vehicle ?
 1.Car or 2.Bike?
2
Enter Registration number :
ASTRR-1234
Driven by elderly ?
  Y or N
Y
Slot number allotted : 1320
Current parking status for Floor #1
[Upper slot : SD12-1233  NF , F, Upper slot : AS53542  NF , P, P]
[-, -, -, -, -]
[P, P, P, P, P]
[P, P, Upper slot : ASTRR-1234  NF  NF  NF  NF , P, P]
[-, -, -, -, -]
[P, P, P, P, P]
Current parking status for Floor #2
[P, P, P, P, P]
[-, -, -, -, -]
[P, P, P, P, P]
[P, P, P, P, P]
[-, -, -, -, -]
[P, P, P, P, P]
Vehicle Outgoing or Incoming?
 1. Incoming 2. Outgoing
2
Which type of vehicle ?
 1.Car or 2.Bike?
2
Vehicle number :
ASTRR-1234
Previous customers : [ASTRR-1234]
 Minutes: 0
Price to be payed : 0.0
removed
Current parking status for Floor #1
[Upper slot : SD12-1233  NF , F, Upper slot : AS53542  NF , P, P]
[-, -, -, -, -]
[P, P, P, P, P]
[P, P,  NF  NF  NF  NF  NF , P, P]
[-, -, -, -, -]
[P, P, P, P, P]
Current parking status for Floor #2
[P, P, P, P, P]
[-, -, -, -, -]
[P, P, P, P, P]
[P, P, P, P, P]
[-, -, -, -, -]
[P, P, P, P, P]
Vehicle Outgoing or Incoming?
 1. Incoming 2. Outgoing
1
Which type of vehicle ?
 1.Car or 2.Bike?
1
Enter number of passengers :
3
Enter Registration number :
AS12-WE1234
Driven by elderly ?
  Y or N
Y
Driven by royal family ?
 Y or N
Y
0 4
5
2 1
3 1
3 0
Slot number allotted : 1200
Current parking status for Floor #1
[Upper slot : SD12-1233  NF , F, Upper slot : AS53542  NF , P, P]
[-, -, -, -, -]
[Upper slot : AS12-WE1234  NF , F, P, P, P]
[F, F,  NF  NF  NF  NF  NF , P, P]
[-, -, -, -, -]
[P, P, P, P, P]
Current parking status for Floor #2
[P, P, P, P, P]
[-, -, -, -, -]
[P, P, P, P, P]
[P, P, P, P, P]
[-, -, -, -, -]
[P, P, P, P, P]
Vehicle Outgoing or Incoming?
 1. Incoming 2. Outgoing
2
Which type of vehicle ?
 1.Car or 2.Bike?
1
Vehicle number :
AS53542
Previous customers : [AS53542, ASTRR-1234]
 Minutes: 1
Price to be payed : 9.0
removed
Current parking status for Floor #1
[Upper slot : SD12-1233  NF , F,  NF  NF , P, P]
[-, -, -, -, -]
[Upper slot : AS12-WE1234  NF , F, P, P, P]
[F, F,  NF  NF  NF  NF  NF , P, P]
[-, -, -, -, -]
[P, P, P, P, P]
Current parking status for Floor #2
[P, P, P, P, P]
[-, -, -, -, -]
[P, P, P, P, P]
[P, P, P, P, P]
[-, -, -, -, -]
[P, P, P, P, P]
Vehicle Outgoing or Incoming?
 1. Incoming 2. Outgoing
