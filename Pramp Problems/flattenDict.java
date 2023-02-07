import java.util.*;

class flattenDict {
  
  static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
    HashMap<String, String> map = new HashMap<>();
    
     flatDict(dict, "", map);
    
    return map;
  }
  
  static void flatDict(HashMap<String, Object> dict, String initialKey, HashMap<String, String> map){
    for(String key : dict.keySet()){
      Object val = dict.get(key);
      
      if(!(val instanceof HashMap<?, ?>)){
        if(key == "" || initialKey == "" || initialKey == null)
          map.put(key + initialKey, ""+val);
        else
          map.put(initialKey+ "." +key, ""+val);
      }
      else{
        if(key == "" || initialKey == "" || initialKey == null)
          flatDict(objectToHashMap(val), key, map);
        else
          flatDict(objectToHashMap(val), initialKey+"."+key, map);
      }
    }
  }
  
  static HashMap<String, Object> objectToHashMap(Object val){
    HashMap hash = (HashMap<String, Object>)val;
    
    return hash;
  }

  public static void main(String[] args) {
    
  }
}