class FoodRatings {
    public class Food{
        String name;
        String cuisine;
        int rating;
        public Food(String name,String cuisine,int rating){
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }
    }

    Map<String, PriorityQueue<Food>> cuisineMap;
    Map<String, Food> foodMap;
    

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cuisineMap = new HashMap();
        foodMap = new HashMap();
        for(int i = 0; i < foods.length; i++){
            Food f = new Food(foods[i], cuisines[i], ratings[i]);
            foodMap.put(foods[i], f);

            if(!cuisineMap.containsKey(cuisines[i])){
                PriorityQueue<Food> pq = 
                new PriorityQueue<Food>(
                    (Food a, Food b) -> 
                    a.rating != b.rating ? b.rating - a.rating : 
                    a.name.compareTo(b.name)
                );
                pq.add(f);
                cuisineMap.put(cuisines[i], pq);
            }
            else
                cuisineMap.get(cuisines[i]).add(f);
        }
    }
    
    public void changeRating(String food, int newRating) {
        Food prev = foodMap.get(food);
        String cuisine = prev.cuisine;
        Food curr = new Food(food, cuisine, newRating);
        foodMap.put(food, curr);

        cuisineMap.get(cuisine).remove(prev);
        cuisineMap.get(cuisine).add(curr);
    }
    
    public String highestRated(String cuisine) {
        return cuisineMap.get(cuisine).peek().name;      
    }   
}