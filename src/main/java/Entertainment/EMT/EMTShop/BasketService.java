package Entertainment.EMT.EMTShop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BasketService {
    private  final Map<String,List<Item>> basketHolder;
    @Autowired
    public BasketService(Map<String, List<Item>> basketHolder){
        this.basketHolder = basketHolder;
    }

    public void addToBasket(String SessionID,List<Item> ItemList){
        if(basketHolder.containsKey(SessionID)){
            for (Item i : ItemList) {
                basketHolder.get(SessionID).add(i);
            }
        }else{
            basketHolder.put(SessionID, ItemList);
        }
    }
    public List<Item> getBasket(String SessionID){
        if(basketHolder.containsKey(SessionID)) {
            return basketHolder.get(SessionID);
        }else{
            List<Item> n = new ArrayList<Item>();
            return n;
        }
    }

    public void clearBasket(String SessionID){
        basketHolder.remove(SessionID);
    }


}
