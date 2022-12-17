Reflection

Vivian: Inspired by the campus map assignment (A6 and A7), our escape room has different rooms inherited from the parent room class. We start by brainstorming the kinds of objects in each room, and the order of how the player moves from one room to the other. After that, we each worked on one of the main searhing rooms (Bedroom, bathroom, and Living room) and integrated the methods into the gameloop class. I also did the basic parent room class and character class so we can build the gameloop and the subclass inheritance.  This project allows me to bring all the things we learn in this class together and see it in action. 
One thing that I learned was using switch cases, because we had a lot of different nested if else statements to anticipate every decision node. Adopting a different syntax like switch cases, not only does it avoid the back end program to cycle through all the if-elses, it also makes code reading a lot clearer. Now, all the switch cases refer to the objects in the room and the possible actions (quit, go back, unlock); the if-else is only used for decision nodes inside the objects. This is my first time using switch cases, so I struggled a little to get the syntax right when I first wrote it. I forgot to use break to conclude the case and whenever I ran the code, it went on to check another object even when I didn’t input the command. 
One thing that I wish we had implemented differently would be making each object its subclass, so that it can be more object oriented and modularize the component. For example, if a closet can become a class on its own, we can have the same closest class in all three rooms. In that case, there will be a dependency/aggregation relationship between the different rooms and the different objects. I would also make the clue more generic for more flexible adjustment. We didn’t choose to make a generic statement for each clue because we want to add variety and replicate a real escape room as much as possible. 
If I had unlimited time, I would probably introduce a timer (like a time bomb) where the player needs to escape the room under a certain time. Currently, it is really hard to quantify the time in our game since everyone solves the clues at a different pace and some people may check objects multiple times. So we don’t have a counter that tracks the total duration of time. I think the most helpful piece of feedback is when my teammate went to ask Jordan about the scanner problem. Instead of initiating a new scanner everytime we take in input, we can use just one, and store the input in a new name when we need to use it. This definitely reduces a lot of the repetitive codes and avoids any unintende side effects like scanner conflicts. 
If I go back in time, I would advise myself to start writing javadoc and agree on a java conventions style naming among the group in the start. We spent way too much time afterward catching up on javadoc and changing to a uniform naming convention for this giant code.It would be so much more efficient if we build small steps from the start. I really enjoyed building this game with my team because we came up with a lot of very creative ideas when it comes to designing the clues. I feel very accomplished everytime I play the game because we literally build it from scratch. Our team was very productive in terms of writing the actual gameloop. It took us only one night to sort through the gameloop. Not only did we divide the work equally, we shared the responsibility of going to TA and office hours, as well as debugging. It is a big project overall, but we made it possible because of our efficient teamwork.


Yujie: I never had the experience of designing an object-oriented project before, and this project really gave me more insights into object oriented programming. When we tried to come up with our ideas about the escape room, instead of thinking in a sequential way, we needed to think about which object this action belongs to, and how to call the method in our Gameloop. This way of thinking is very new to me and I feel like I adapted to an object-oriented way of thinking better through working on this project. Although we tried our best to put methods into different classes, our program was still not object-oriented enough because we do have sequential actions that need the user to follow the instructions. This is something we can potentially improve but also very hard to avoid in an escape room design because users could only have the permission to go to the next room after they found the key or passcode. I also had a great experience of working with my group members. We spend a lot of time brainstorming, writing codes, decoding and I really learned a lot from my group members. 

Zhirou: Our escape room project gives me an opportunity to review what we have learned in the past semester. We divide the work by each group member building one of the subclasses and collaboratively build the main Gameloop class together. We start with how to find the key in a room and how to guide the user to go over each step. Then we designed the room and tried to anticipate what actions are needed for the character. After that, we build the character class and the main class to connect the storyline together. In this process, our collaboration makes our progress efficient and productive. Our ideas let the game make more sense. Meanwhile, we also came through many problems like too many if-else statements and having other loops contained in a loop etc. We spent a lot of time trying to figure it out and asked help from our professor and TAs to end up with the codes we have for now. I learned how to think critically about our code and how to improve the code. This experience makes me become more interested in programming and want to explore it in-depth.