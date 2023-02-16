package tdm.pml.FrontEnd;

import java.io.FileNotFoundException;
import java.util.List;

import javafx.application.*;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.text.Text; 
import tdm.pml.BaseValueClass;
import tdm.pml.Boat;
import tdm.pml.Contract;
import tdm.pml.CrewMember;
import tdm.pml.Player;
import tdm.pml.ContractList;
import javafx.scene.text.*;

//mvn clean javafx:run

public class FrontEnd extends Application{ 	
    private Scene scene;
    private Rectangle2D screenBounds;
    private Group root;
    private HBox boatBox;
    private ImageView sail;
    private ImageView motor;
    private ImageView hoverCraft;
    private ImageView cargo;

    private VBox shopMenu;
    private VBox menuBox;
    private HBox topMenu;
    private Text balance;

    private VBox garageMenu;
    private VBox garageDisplay;

    private VBox contractMenu;
    private VBox contractDisplay;

    private HBox exitBox;
    private Button exit;

    private BaseValueClass b;
    private Player p;
    private ContractList cl;

    @Override
    public void start(Stage stage) throws FileNotFoundException{
        //Scalable upon opening program
        screenBounds = Screen.getPrimary().getBounds();
        final double sW = screenBounds.getWidth();
        final double sH = screenBounds.getHeight();
        double oceanHeight = sH-250;
        b = new BaseValueClass();
        cl = new ContractList();

        //containers and layouts
        root = new Group();

        HBox shopButtonBox = new HBox();
        shopButtonBox.setAlignment(Pos.BOTTOM_CENTER);
        shopButtonBox.setMinHeight(sH-80);
        shopButtonBox.setMinWidth(sW);

        HBox sandBox = new HBox();
        sandBox.setAlignment(Pos.BOTTOM_CENTER);
        sandBox.setMinHeight(sH);
        sandBox.setMinWidth(sW);

        HBox displayBoats = new HBox();
        displayBoats.setAlignment(Pos.CENTER_LEFT);
        displayBoats.setMinHeight(oceanHeight);
        displayBoats.setMinWidth(sW);
    
        boatBox = new HBox();
        boatBox.setAlignment(Pos.BOTTOM_CENTER);
        boatBox.setMinHeight(oceanHeight);
        boatBox.setMinWidth(sW/3);
        displayBoats.getChildren().add(boatBox);

        VBox center = new VBox();
        center.setAlignment(Pos.TOP_CENTER);
        center.setMinHeight(sH);
        center.setMinWidth(sW);

        shopMenu = new VBox();
        shopMenu.setAlignment(Pos.CENTER);
        shopMenu.setMinHeight(oceanHeight);
        shopMenu.setMinWidth(sW);

        menuBox = new VBox();
        menuBox.setAlignment(Pos.CENTER);
        menuBox.setMinHeight(oceanHeight);
        menuBox.setMinWidth(sW);

        garageMenu = new VBox();
        garageMenu.setAlignment(Pos.CENTER);
        garageMenu.setMinHeight(oceanHeight);
        garageMenu.setMinWidth(sW);

        garageDisplay = new VBox();
        garageDisplay.setAlignment(Pos.CENTER);
        garageDisplay.setMinHeight(oceanHeight);
        garageDisplay.setMinWidth(sW);

        contractMenu = new VBox();
        contractMenu.setAlignment(Pos.CENTER);
        contractMenu.setMinHeight(oceanHeight);
        contractMenu.setMinWidth(sW);

        contractDisplay = new VBox();
        contractDisplay.setAlignment(Pos.CENTER);
        contractDisplay.setMinHeight(oceanHeight);
        contractDisplay.setMinWidth(sW);

        //scene creation
        scene = new Scene(root, sW, sH-75);
        scene.setFill(Color.AQUA);

        //Images
        Image oceanGif = new Image("file:images\\oceanGif.gif", sW, oceanHeight, false, false);

        Image sailImage = new Image("file:images\\sail.gif", sW - sW*0.9, sH-sH*0.9, true, true);
        sail = new ImageView(sailImage);

        Image motorImage = new Image("file:images\\motorBoat.gif", sW - sW*0.9, sH-sH*0.9, true, true);
        motor = new ImageView(motorImage);

        Image hoverCraftImage = new Image("file:images\\hoverCraft.gif", sW - sW*0.9, sH-sH*0.9, true, true);
        hoverCraft = new ImageView(hoverCraftImage);

        Image cargoImage = new Image("file:images\\cargoShip.gif", sW - sW*0.9, sH-sH*0.9, true, true);
        cargo = new ImageView(cargoImage);
        
        Rectangle background = new Rectangle();
        background.setWidth(sW);
        background.setHeight(oceanHeight);
        background.setFill(new ImagePattern(oceanGif));

        Image shopImage = new Image("file:images\\shop.png", sW - sW*0.9, sH-sH*0.9, true, true);
        ImageView shop = new ImageView(shopImage);

        Image sandImage = new Image("file:images\\sand.jpg", sW, sH-oceanHeight, false, false);

        Image garageImage = new Image("file:images\\garage.png", sW - sW*0.9, sH-sH*0.9, true, true);
        ImageView garage = new ImageView(garageImage);

        Button garageButton = new Button();
        garageButton.setMinHeight(sH-sH*0.85);
        garageButton.setMinWidth(sW-sW*0.9);
        garageButton.setStyle("-fx-background-color: #fea05a; ");
        garageButton.setGraphic(garage);
        garageButton.setAlignment(Pos.CENTER);
        garageButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                double menuH = sH - sH*0.5;
                double menuW = sW - sW*0.45;

                Rectangle menuBackground = new Rectangle(menuW, menuH*1.10, Color.WHITESMOKE);

                exit = new Button("X");
                exit.setMinHeight(sH-sH*5.5);
                exit.setMinWidth(sW-sW*5.5);
                exit.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent e){
                        garageMenu.getChildren().clear();
                        garageDisplay.getChildren().clear();
                        root.getChildren().removeAll(garageDisplay, garageMenu);  
                    }
                });

                exitBox = new HBox();
                exitBox.setMinHeight(menuH - menuH*0.95);
                exitBox.setMaxWidth(sW - sW*0.45);
                exitBox.setStyle("-fx-border-color: black; \n" + "-fx-border-width: 2;");
                exitBox.setAlignment(Pos.TOP_RIGHT);
                exitBox.getChildren().add(exit);

                VBox boatContainer = new VBox();
                boatContainer.setMinHeight(menuH - menuH*0.05);
                boatContainer.setMinWidth(menuW);
                boatContainer.setMaxWidth(menuW);
                boatContainer.setStyle("-fx-border-color: black; \n" + "-fx-border-width: 2;");
                List<Boat> boatList = p.getBoats();
                for(int i = 0; i < boatList.size(); i++){
                    Boat boat = boatList.get(i);
                    boatContainer.getChildren().add(genVBox(menuH, menuW, boat.getName() + ", ID: " + i, "Status: " + (boat.getContracts().size() != 0 ? "Active" : "Inactive"), "Max weight capacity: " + boat.getMaxWeightCapacity() + "lbs", "Current contract time remaining: " + (boat.getContracts().size() != 0 ? boat.getContracts().get(0).getTimeLeft() + "s": "No contract currently running"), false, boat, null, false));
                } 
                ScrollPane newBoatContainer = new ScrollPane(boatContainer);
                newBoatContainer.setMaxHeight(menuH);
                newBoatContainer.setMinHeight(menuH - menuH*0.05);
                newBoatContainer.setMaxWidth(menuW);

                VBox crewContainer = new VBox();
                crewContainer.setMinHeight(menuH - menuH*0.05);
                crewContainer.setMinWidth(menuW);
                crewContainer.setMaxWidth(menuW);
                List<Boat> boat = p.getBoats();
                for(int x=0; x < boat.size(); x++) {
                    List<CrewMember> crew = boat.get(x).getCrew();
                    for(int i = 0; i < crew.size(); i++){
                        CrewMember crewMember = boat.get(x).getCrew().get(i);
                        crewContainer.getChildren().add(genVBox(menuH, menuW, crewMember.getType().toString(), "Belongs to: " + boat.get(x).getName() + " : " + x, "Name: " + crewMember.getName(), "Weight: " + String.format("%.0f", crewMember.getWeight()) +" lbs", false, null, crewMember, false));
                    }
                }
                
                ScrollPane newCrewContainer = new ScrollPane(crewContainer);
                newCrewContainer.setMaxHeight(menuH);
                newCrewContainer.setMinHeight(menuH - menuH*0.05);
                newCrewContainer.setMaxWidth(menuW);

                HBox mainContainer = new HBox();
                mainContainer.setMinHeight(menuH - menuH*0.05);
                mainContainer.setMaxWidth(menuW);
                mainContainer.setStyle("-fx-border-color: black; \n" + "-fx-border-width: 2;");
                mainContainer.getChildren().addAll(newBoatContainer, newCrewContainer);

                garageMenu.getChildren().addAll(exitBox, mainContainer);
                garageDisplay.getChildren().add(menuBackground);
                root.getChildren().addAll(garageDisplay, garageMenu);
            }
        });

        Image contractImage = new Image("file:images\\contract.png", sW - sW*0.9, sH-sH*0.9, true, true);
        ImageView contract = new ImageView(contractImage);

        Button contractButton = new Button();
        contractButton.setMinHeight(sH-sH*0.85);
        contractButton.setMinWidth(sW-sW*0.9);
        contractButton.setStyle("-fx-background-color: #fea05a; ");
        contractButton.setGraphic(contract);
        contractButton.setAlignment(Pos.CENTER);
        contractButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                double menuH = sH - sH*0.5;
                double menuW = sW - sW*0.45;

                Rectangle menuBackground = new Rectangle(menuW, menuH*1.10, Color.WHITESMOKE);

                exit = new Button("X");
                exit.setMinHeight(sH-sH*5.5);
                exit.setMinWidth(sW-sW*5.5);
                exit.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent e){
                        contractMenu.getChildren().clear();
                        contractDisplay.getChildren().clear();
                        root.getChildren().removeAll(contractDisplay, contractMenu);
                    }
                });

                exitBox = new HBox();
                exitBox.setMinHeight(menuH - menuH*0.95);
                exitBox.setMaxWidth(sW - sW*0.45);
                exitBox.setStyle("-fx-border-color: black; \n" + "-fx-border-width: 2;");
                exitBox.setAlignment(Pos.TOP_RIGHT);
                exitBox.getChildren().add(exit);

                VBox boatContainer = new VBox();
                boatContainer.setMinHeight(menuH - menuH*0.05);
                boatContainer.setMinWidth(menuW*0.5);
                boatContainer.setMaxWidth(menuW*0.5);
                List<Contract> contracts = cl.getAvailableContracts();
                for(int i = 0; i < contracts.size(); i++){
                    Contract contract = contracts.get(i);
                    boatContainer.getChildren().add(getContractBox(menuH, menuW, "Contract", "Payment: " + String.format("%.0f", contract.getPayment()) + "$", "Duration: " + contract.getDuration(), "Weight: " + String.format("%.0f", contract.getTotalWeight()) + " lbs", true, null, null, contract, boatContainer));
                } 
                boatContainer.setStyle("-fx-border-color: black; \n" + "-fx-border-width: 2;");
                ScrollPane newBoatContainer = new ScrollPane(boatContainer);
                newBoatContainer.setMaxHeight(menuH);
                newBoatContainer.setMinHeight(menuH - menuH*0.05);
                newBoatContainer.setMaxWidth(menuW);
                

                VBox crewContainer = new VBox();
                crewContainer.setMinHeight(menuH - menuH*0.05);
                crewContainer.setMinWidth(menuW*0.5);
                crewContainer.setMaxWidth(menuW*0.5);
                crewContainer.setStyle("-fx-border-color: black; \n" + "-fx-border-width: 2;");
                List<Boat> boats = Player.getBoats();
                for (int i=0; i < boats.size(); i++) {
                    List<Contract> contracts1 = boats.get(i).getContracts();
                    for(int x = 0; x < contracts1.size(); x++){
                        Contract contract = contracts1.get(x);
                        crewContainer.getChildren().add(getContractBox(menuH, menuW, "Contract", "Payment: " + String.format("%.0f", contract.getPayment()) + "$", "Time Left: " + String.format("%.0f", contract.getTimeLeft()) + "s", "Boat: " + boats.get(i).getName(), false, null, null, contract, boatContainer));
                    } 
                }
                ScrollPane newCrewContainer = new ScrollPane(crewContainer);
                newCrewContainer.setMaxHeight(menuH);
                newCrewContainer.setMinHeight(menuH - menuH*0.05);
                newCrewContainer.setMaxWidth(menuW);


                HBox mainContainer = new HBox();
                mainContainer.setMinHeight(menuH - menuH*0.05);
                mainContainer.setMaxWidth(menuW);
                mainContainer.setStyle("-fx-border-color: black; \n" + "-fx-border-width: 2;");
                mainContainer.getChildren().addAll(newBoatContainer, newCrewContainer);

                contractMenu.getChildren().addAll(exitBox, mainContainer);
                contractDisplay.getChildren().add(menuBackground);
                root.getChildren().addAll(contractDisplay, contractMenu);
            }
        });

        Button mainShop = new Button();
        mainShop.setMinHeight(sH-sH*0.85);
        mainShop.setMinWidth(sW-sW*0.9);
        mainShop.setStyle("-fx-background-color: #fea05a; ");
        mainShop.setGraphic(shop);
        mainShop.setAlignment(Pos.CENTER);
        mainShop.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                double menuH = sH - sH*0.5;
                double menuW = sW - sW*0.45;

                Rectangle menuBackground = new Rectangle(menuW, menuH*1.10, Color.WHITESMOKE);
                
                exit = new Button("X");
                exit.setMinHeight(sH-sH*5.5);
                exit.setMinWidth(sW-sW*5.5);
                exit.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent e){
                        menuBox.getChildren().clear();
                        shopMenu.getChildren().clear();
                        root.getChildren().removeAll(shopMenu, menuBox);
                    }
                });

                balance = new Text("Balance: " + p.getMoney() + "$");
                balance.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20)); 

                HBox balanceBox = new HBox();
                balanceBox.setMinHeight(menuH - menuH*0.95);
                balanceBox.setMinWidth((sW - sW*0.45)/2);
                balanceBox.setMaxWidth(sW - sW*0.45);
                balanceBox.setAlignment(Pos.TOP_LEFT);
                balanceBox.getChildren().add(balance);

                exitBox = new HBox();
                exitBox.setMinHeight(menuH - menuH*0.95);
                exitBox.setMinWidth((sW - sW*0.45)/2);
                exitBox.setMaxWidth(sW - sW*0.45);
                exitBox.setAlignment(Pos.TOP_RIGHT);
                exitBox.getChildren().add(exit);

                topMenu = new HBox();
                topMenu.setMinHeight(menuH - menuH*0.95);
                topMenu.setMaxWidth(sW - sW*0.45);
                topMenu.setStyle("-fx-border-color: black; \n" + "-fx-border-width: 2;");
                topMenu.getChildren().addAll(balanceBox, exitBox);

                VBox boatContainer = new VBox();
                boatContainer.setMinHeight(menuH - menuH*0.05);
                boatContainer.setMinWidth(menuW*0.5);
                boatContainer.setMaxWidth(menuW*0.5);
                List<Boat> boatList = b.getBoats();
                for(int i = 0; i < boatList.size(); i++){
                    Boat boat = boatList.get(i);
                    boatContainer.getChildren().add(genVBox(menuH, menuW, boat.getName(), "Price: " + boat.getPrice() + "$", "Factory weigth: " + boat.getfactoryWeight() + " lbs", "Max weight capacity: " + boat.getMaxWeightCapacity() + " lbs", true, boat, null, true));
                } 
                boatContainer.setStyle("-fx-border-color: black; \n" + "-fx-border-width: 2;");

                VBox crewContainer = new VBox();
                crewContainer.setMinHeight(menuH - menuH*0.05);
                crewContainer.setMinWidth(menuW*0.5);
                crewContainer.setMaxWidth(menuW*0.5);
                List<CrewMember> crew = b.getCrew();
                for(int i = 0; i < crew.size(); i++){
                    CrewMember crewMember = crew.get(i);
                    crewContainer.getChildren().add(genVBox(menuH, menuW, crewMember.getType().toString(), "Price: " + crewMember.getPricePerTrip() + "$", "Name: " + crewMember.getName(), "Weigth: " + crewMember.getWeight() + " lbs", false, null, crewMember, true));
                } 
                

                crewContainer.setStyle("-fx-border-color: black; \n" + "-fx-border-width: 2;");

                HBox mainContainer = new HBox();
                mainContainer.setMinHeight(menuH - menuH*0.05);
                mainContainer.setMaxWidth(menuW);
                mainContainer.setStyle("-fx-border-color: black; \n" + "-fx-border-width: 2;");
                mainContainer.getChildren().addAll(boatContainer, crewContainer);

                menuBox.getChildren().addAll(topMenu, mainContainer);
                shopMenu.getChildren().add(menuBackground);
                root.getChildren().addAll(shopMenu, menuBox);
            }
        });

        Rectangle sandGraphic = new Rectangle();
        sandGraphic.setWidth(sW);
        sandGraphic.setHeight(sH-oceanHeight);
        sandGraphic.setFill(new ImagePattern(sandImage));

        sandBox.getChildren().add(sandGraphic);
        center.getChildren().add(background);
        shopButtonBox.getChildren().addAll(garageButton, mainShop, contractButton);
        root.getChildren().addAll(center, sandBox, displayBoats,shopButtonBox);

        //associate scene to stage and show
        stage.setTitle("Hello JavaFX"); 
        stage.setScene(scene); 
        stage.show(); 
    }

    /**
     * @Description Creates a VBox based on input to facilitate displaying boat information or crew member information
     * @param numH
     * @param numW
     * @param textwords
     * @param textwords2
     * @param textwords3
     * @param textwords4
     * @param buyBoatButton
     * @param boat
     * @param crewMember
     * @param buyButtonBool
     * @return
     */
    public VBox genVBox(Double numH, Double numW, String textwords, String textwords2, String textwords3, String textwords4, final boolean buyBoatButton, final Boat boat , final CrewMember crewMember, boolean buyButtonBool) {
        VBox genBox = new VBox();
        genBox.setAlignment(Pos.CENTER);
        genBox.setMinHeight(numH - numH*0.75);
        genBox.setMinWidth(numW*0.5);
        genBox.setMaxWidth(numW*0.5);
        genBox.setStyle("-fx-border-color: black; \n" + "-fx-border-width: 1;");
        Text text = new Text(); 
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20)); 
        text.setText(textwords); 
        Text text1 = new Text(); 
        text1.setText(textwords2);
        Text text2 = new Text(); 
        text2.setText(textwords3);
        Text text3 = new Text(); 
        text3.setText(textwords4);
        genBox.getChildren().add(text);
        genBox.getChildren().add(text1);
        genBox.getChildren().add(text2);
        genBox.getChildren().add(text3);        

        if (buyButtonBool) {
            Button buyButton = new Button("Buy");
            buyButton.setOnAction(new EventHandler<ActionEvent>(){
    
                @Override
                public void handle(ActionEvent arg0) {       
                    if (buyBoatButton){
                        if (Player.addBoat(boat)){
                            addBoatToDisplay(boat.getName());
                        }
                        balance.setText("Balance: " + Player.getMoney() + "$"); 
                        System.out.println(Player.getBoats());
                    } else {
                        Player.addCrewMember(crewMember);
                        balance.setText("Balance: " + Player.getMoney() + "$"); 
                    } 
                }
            });
            genBox.getChildren().add(buyButton);
        }
        return genBox;
    }

    /**
     * @Description Creates a VBox based on input to facilitate displaying contract list information
     * @param numH
     * @param numW
     * @param textwords
     * @param textwords2
     * @param textwords3
     * @param textwords4
     * @param buyBoatButton
     * @param boat
     * @param crewMember
     * @param contract
     * @param container
     * @return
     */
    public VBox getContractBox(Double numH, Double numW, String textwords, String textwords2, String textwords3, String textwords4, final boolean buyBoatButton, final Boat boat , final CrewMember crewMember, final Contract contract, final VBox container) {
        final VBox genBox = new VBox();
        genBox.setAlignment(Pos.CENTER);
        genBox.setMinHeight(numH - numH*0.75);
        genBox.setMinWidth(numW*0.5);
        genBox.setMaxWidth(numW*0.5);
        Text text = new Text(); 
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20)); 
        text.setText(textwords); 
        Text text1 = new Text(); 
        text1.setText(textwords2);
        Text text2 = new Text(); 
        text2.setText(textwords3);
        Text text3 = new Text(); 
        text3.setText(textwords4);
        genBox.getChildren().add(text);
        genBox.getChildren().add(text1);
        genBox.getChildren().add(text2);
        genBox.getChildren().add(text3);   
        genBox.setStyle("-fx-border-color: black; \n" + "-fx-border-width: 1;");     

        if (buyBoatButton) {
            Button buyButton = new Button("Accept");
            buyButton.setOnAction(new EventHandler<ActionEvent>(){
    
                @Override
                public void handle(ActionEvent arg0) {   
                    for (int i=0; i < Player.getBoats().size(); i++) {
                        if (Player.getBoats().get(i).getContracts().size() == 0 && Player.getBoats().get(i).getMaxWeightCapacity() >= contract.getTotalWeight() && Player.getBoats().get(i).hasAllCrewMembers()) {
                            Player.getBoats().get(i).setContract(contract);
                            genBox.getChildren().clear();
                            container.getChildren().remove(genBox);
                            root.getChildren().removeAll(genBox);
                            cl.getAvailableContracts().remove(contract);
                            balance.setText("Balance: " + Player.getMoney() + "$"); 
                            break;
                        }
                    }
                }

            });
            Button buyButton2 = new Button("Decline");
            buyButton2.setOnAction(new EventHandler<ActionEvent>(){
    
                @Override
                public void handle(ActionEvent arg0) {                       
                    try {
                        genBox.getChildren().clear();
                        container.getChildren().remove(genBox);
                        root.getChildren().removeAll(genBox);
                        cl.getAvailableContracts().remove(contract);
                    } catch (Exception e) {
                        
                    }    
                }  
            });
            genBox.getChildren().add(buyButton);
            genBox.getChildren().add(buyButton2);
        }
        return genBox;
    }

    /**
     * @Description Purely for design, adds a gif of the chosen boat once you buy it from shop. Can only display 4 of the different types of boats
     * @param boatName
     */
    public void addBoatToDisplay(String boatName){
       switch (boatName) {
            case "Sail":
                if (boatBox.getChildren().contains(sail)){
                    break;
                }
                boatBox.getChildren().add(sail);
                break;
            case "Motor":
                if (boatBox.getChildren().contains(motor)){
                    break;
                }
                boatBox.getChildren().add(motor);
                break;
            case "HoverCraft":
                if (boatBox.getChildren().contains(hoverCraft)){
                    break;
                }
                boatBox.getChildren().add(hoverCraft);
                break;
            case "Cargo":
                if (boatBox.getChildren().contains(cargo)){
                    break;
                }
                boatBox.getChildren().add(cargo);
                break;
        }

    }
}   
