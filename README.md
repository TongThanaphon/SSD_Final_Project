# SSD_Final_Project
## About This Application
<strong>BankApp</strong> it is the application with User Interface use to deposit, withdraw and transfer money with any currency. The base money in the account is THB such as user deposit 1 usd to accout, it will change to 32 THB and save in user accout.

## How to run
1. Clone this project and run file ``` LoginGUI.java ```
2. Input the id accout(6 numbers digit). If you don't have id, it will created for you.
3. When you login success, it will show select menu window and userinfo window. The userinfo window will update the moeny in your accout when you deposit, withdraw or transfer money. </br>
<strong>Deposit/Withdraw</strong>
 - If you select this menu, it will show this window.
 
 - When you select deposit 1 usd, the userinfo window will updated.
 
<strong>Transfer</strong> </br>
 - If you select this menu, it will show this window.
 
 - When you input the receiver id, amount and select type of currency then click submit it will tansfer moeny to that id and your money in account will decrease.
 
 - If you input the id that it does not has in the data base, it will show like this.

## Design Pattern
![Alt text](UML.png?raw=true "UML")

<strong>Obbserver</strong> The User class extend Observable and UserInfoGUI implements Observer, it will notify to GUI when the user has do someting about money in the account (deposit, withdraw and transfer). </br>
<strong>Singleton</strong> Define the DbManager class as the class that use singleton pattern to protect calling mulitple time for store data.</br>
<strong>Stategy</strong> Deposit, Withdraw and Transfer class create all of this class as interface and it has method that do about each activity. It is easy when you want to add more curreny for exchange to this app.</br>
