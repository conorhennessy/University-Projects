package mobiledev.unb.ca.roompersistencelab;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

/**
 * This DAO object validates the SQL at compile-time and associates it with a method
 */
@Dao
public interface ItemDao {
    // TODO Add app specific queries in here
    // Additional details can be found at https://developer.android.com/reference/android/arch/persistence/room/Dao
}
