package mobiledev.unb.ca.roompersistencelab;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class ItemViewModel extends AndroidViewModel {
    private ItemRepository itemRepository;

    public ItemViewModel(@NonNull Application application) {
        super(application);
        itemRepository = new ItemRepository(application);
    }

    // TODO Add mapping calls between the UI and Database
}
