# An idle boat game made using java and rendered using basic javafx for school project

ICM - Idle Cargo Manager

1. Make sure to be in icm folder in terminal
2. Run command: mvn clean javafx:run

There will be 3 buttons displayed at the bottom of the screen. 

The left button is the garage where it displays all the boats you own as well as your crew members that you own. **NOTE** : you must have all four types of crewmates for a boat in order to start accepting contracts.

The middle button is the shop where you can buy new boats and crew members. It also displays your bank account. **NOTE** : When you buy a new boat it will come with no crew members, you need to buy at least 1 of each type of crew member before being able to accept a contract, and when you buy a crew member, you buy it for all of the boats.

The right button is the contract board where it displays all contracts. New contracts appear every **10** **seconds**. You can only accept a contract when you have a boat that can handle the amount of weight shown and have the four crew member types. **NOTE** : You can only accept 1 contract per boat 

After accepting a contract, you will have to wait a certain amount of seconds to complete and get paid. In that time period, based on what packages you have and the boat holding the contract, there will be special methods (Randomizers / multipliers) that will change the overall payout of the contract.

For example: Sail boat allows you to get more money by catching fish and selling them, the hover craft shortens the time of the contract and the cargo ship adds another bonus contract to earn even more money. The packages can also be stolen or destroyed which reduces the amount you make.

**NOTE** : There is no "javafx validation", as in the buttons do not get disabled when clicking on another menu so there can be visual glitches if you spam buttons, but they do not affect backend logic.

