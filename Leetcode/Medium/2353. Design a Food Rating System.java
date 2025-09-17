class Food{
    String food;
    String cuisine;
    int rating;
    Food(String food,String cuisine,int rating){
        this.food=food;
        this.cuisine=cuisine;
        this.rating=rating;
    }
}
class FoodRatings {
    HashMap<String,Food> foodMap;
    HashMap<String,TreeSet<Food>> cuisineMap;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodMap=new HashMap<>();
        cuisineMap=new HashMap<>();
        for(int i=0;i<foods.length;i++){
            Food temp=new Food(foods[i],cuisines[i],ratings[i]);
            foodMap.put(foods[i],temp);
            if(!cuisineMap.containsKey(cuisines[i])){
                cuisineMap.put(cuisines[i],new TreeSet<>(
                    (a,b)->{
                        if(b.rating != a.rating){
                            return b.rating-a.rating;
                        }
                        else{
                            return a.food.compareTo(b.food);
                        }
                    }
                ));
                
            }
            cuisineMap.get(cuisines[i]).add(temp);
        }
    }
    
    public void changeRating(String food, int newRating) {
        Food temp=foodMap.get(food);
        TreeSet<Food> set=cuisineMap.get(temp.cuisine);
        set.remove(temp); //removes old food;
        temp.rating=newRating;
        set.add(temp);
       
    }
    
    public String highestRated(String cuisine) {
        return cuisineMap.get(cuisine).first().food;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
