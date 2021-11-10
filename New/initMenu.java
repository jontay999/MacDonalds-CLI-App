package MacDonalds.New;

import java.time.LocalDateTime;

public class initMenu {
    Menu menu0 = new Menu("Singapore Menu",LocalDateTime.now());
    Menu menu2 = new Menu("Breakfast Menu", LocalDateTime.now());

    initMenu(){
        //add alacarte items
        Alacarte item1 = new Alacarte("Chicken McCrispy", "Chicken McCrispy® (6pc) comes with 3 thighs and 3 drumsticks.", (float)8.70, Category.MAIN_COURSE);
        Alacarte item2 = new Alacarte("Plant McVeggie", "Freshly made with veggies and plant based meat suitable for vegetarians.", (float)8.70, Category.MAIN_COURSE);
        Alacarte item3 = new Alacarte("Buttermilk Crispy Chicken", "Served with white cheddar cheese, romaine lettuce, black pepper mayo; and topped with grilled pineapple rings and crisp purple cabbage.", (float)6.95, Category.MAIN_COURSE);
        Alacarte item4 = new Alacarte("Angus Cheeseburger", "Made from all the things you love – two slices of melty cheese, slivered onions and 100% Angus beef. All between aromatic glazed buns for an irresistible finish.", (float)6.00, Category.MAIN_COURSE);
        Alacarte item5 = new Alacarte("Cheeseburger", "Start with a perfect McDonald’s Hamburger. Put warm, melting cheese on the patty and take the experience to the next level.", (float)3.65, Category.MAIN_COURSE);
        Alacarte item6 = new Alacarte("Coke Zero", "Taste the goodness of zero sugar, a healthier alternative!", (float)2.60, Category.DRINKS);
        Alacarte item7 = new Alacarte("Iced Lemon Tea", "Freshly squeezed lemons topped with ice.", (float)2.10, Category.DRINKS);
        Alacarte item8 = new Alacarte("McCafé Latte", "Made with espresso topped with hot velvety milk, making for an oh-so comforting coffee experience",(float)4.30, Category.DRINKS);
        Alacarte item9 = new Alacarte("Double Chocolate Frappe", "Chocolate chips with whipped cream blended to form the perfect chocolatey drink.", (float)4.30, Category.DRINKS);
        Alacarte item10 = new Alacarte("Oreo McFlurry", "The rich taste of crumbled oreos with the all time favourite Vanilla ice-cream", (float)3.80, Category.DESSERT);
        Alacarte item11 = new Alacarte("Mudpie McFlurry", "Mix up the mundane with this delicious flurry of fun.", (float)3.80, Category.DESSERT);
        Alacarte item12 = new Alacarte("Hot Fudge Sundae", "We know how our Sundaes can affect you. We love them too.", (float)2.20, Category.DESSERT);
        Alacarte item13 = new Alacarte("ChocoCone®", "Don’t let that chocolaty hard shell fool you. This one is a real softy inside", (float)1.10, Category.DESSERT);
        Alacarte item14 = new Alacarte("Strawberry Sundae", "We know how our Sundaes can affect you. We love them too.", (float)2.20, Category.DESSERT);
        Alacarte item15 = new Alacarte("French Fries", "For winning flavour and texture, we only use premium Russet Burbank variety potatoes for that fluffy inside, crispy outside taste of our world-famous fries.", (float)2.15, Category.SIDES);
        Alacarte item16 = new Alacarte("Corn Cup", "Veg up with crunchy corn kernels and enjoy a yummy serving of antioxidants.", (float)1.95, Category.SIDES);
        Alacarte item17 = new Alacarte("Apple Slices", "Go fruity with fresh, ready-to-eat apple slices!", (float)1.90, Category.SIDES);
        Alacarte item18 = new Alacarte("Hashbrown", "Golden brown and crispy on the outside, soft and moist on the inside.", (float)2.30, Category.SIDES);
        Alacarte item19 = new Alacarte("Chocolate Muffin", "You already know what this is, and you love it.", (float)2.00, Category.SIDES);
        menu0.addItem(item1);
        menu0.addItem(item2); 
        menu0.addItem(item3);  
        menu0.addItem(item4);  
        menu0.addItem(item5);   
        menu0.addItem(item6); 
        menu0.addItem(item7); 
        menu0.addItem(item8);  
        menu0.addItem(item9);   
        menu0.addItem(item10);  
        menu0.addItem(item11); 
        menu0.addItem(item12);
        menu0.addItem(item13);  
        menu0.addItem(item14);  
        menu0.addItem(item15); 
        menu0.addItem(item16);  
        menu0.addItem(item17);  
        menu0.addItem(item18);
        menu0.addItem(item19);  

        //add set items
        Set set1 = new Set("McCrispy Meal", "Your favourite burgers now come with a set meal for maximum value");
        set1.addAlacarteItem(item1);set1.addAlacarteItem(item6);set1.addAlacarteItem(item12);
        Set set2 = new Set("McVeggie Meal", "A meal specially for our vegetarian friends, a completely balanced diet!");
        set2.addAlacarteItem(item2);set2.addAlacarteItem(item7);set2.addAlacarteItem(item16);
        Set set3 = new Set("Dessert Meal", "Putting together your favourite desserts for all those with a sweet tooth!");
        set3.addAlacarteItem(item9);set3.addAlacarteItem(item13);set3.addAlacarteItem(item19);
        menu0.addItem(set1);
        menu0.addItem(set2);
        menu0.addItem(set3);
    }

    public Menu getMenu(int num) {
        if(num==0)return this.menu0;
        else return this.menu0;
    }

}
