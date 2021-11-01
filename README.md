# FinalEpicBattleSimulator
**CS5004 Creative Lab**</p>

A character has strength, hitPoints, and a name. All characters have an attack method that will return from 1 to strength. </p>

A hero and a bad guy are both characters. Heroes also have mana and two additional attacks, attackWithWeapon and specAttackWithWeapon. 
Heroes also have the ability to have a weapon. Bad guys speak random phrases before each attack.
Weapon has an attack that returns a random number from some number to its strength, but everytime the attack method is used it deducts 1 from durability.
If durability drops to 0, the weapon breaks and will only ever return 0 with its attack method. </p>

Melee is a weapon that has a high strength based special attack but takes a high durability cost. </p>

Ranged is a weapon that has a low strength based attack, but has a random chance of doing more or less damage with its special attack(or missing entirely). </p>

Magic is a weapon that uses very little durability, but deducts mana from the hero for every use. 
If the hero runs out of mana, then it only returns 0. 
It has a special attack that uses more mana, but does more damage. </p>

A BattleArena takes a list of Heros and a list of bad guys and randomly pits them against each other.
A weapon rack is a list of weapons you may offer your hero prior to the battle.
The Battle Arena select combatants print their information, print the available weapons, let the user select a weapon to equip to a hero and then start a battle loop. Before each attack allow your user to select attack, attack with equipped weapon, or special attack with weapon. Repeat this process until all the bad guys or all of the heroes are defeated. </p>

The driver will set all of this up and run it.</p>

Add at least 1 creative element. It could have to do with the battling; it could be music, it could be a graphical interface; or any other element you’d like to explore. 
