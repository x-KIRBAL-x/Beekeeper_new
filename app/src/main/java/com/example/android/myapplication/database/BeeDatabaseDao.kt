package com.example.android.myapplication.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface BeeDatabaseDao {

    @Insert
    suspend fun insertGroup(group: BeeGroup)

    @Update
    suspend fun updateGroup(group: BeeGroup)

    @Insert
    suspend fun insertHive(hive: Beehive)

    @Update
    suspend fun updateHive(hive: Beehive)

    @Query("DELETE FROM bee_group_table")
    suspend fun deleteAllGroups()

    @Query("DELETE FROM bee_group_table WHERE groupId= :key")
    suspend fun deleteGroupWithId(key: Long)

    @Query("DELETE FROM beehive_table WHERE beehiveId= :key")
    suspend fun deleteBeehiveWithId(key: Long)

    @Query("SELECT * FROM bee_group_table WHERE groupId = :key")
    suspend fun getgroup(key: Long): BeeGroup

    @Query("SELECT * FROM beehive_table WHERE beehiveId = :key")
    suspend fun getBeeHive(key: Long): Beehive

    @Query("SELECT * FROM bee_group_table ORDER BY groupId DESC LIMIT 1")
    suspend fun getLastGroup(): BeeGroup?

    @Query("SELECT * FROM beehive_table ORDER BY beehiveId DESC LIMIT 1")
    suspend fun getLastBeehive(): Beehive?

    @Query("SELECT * FROM bee_group_table WHERE groupId = :key")
    fun getGroupWithId(key: Long): LiveData<BeeGroup>

    @Query("SELECT * FROM beehive_table WHERE beehiveId = :key")
    fun getBeehiveWithId(key: Long): LiveData<Beehive>

    @Query("SELECT * FROM beehive_table WHERE group_id = :key ORDER BY beehive_name ASC")
    fun getAllBeehiveWithId(key: Long): LiveData<List<Beehive>>

    @Query("SELECT * FROM beehive_table WHERE group_id = :key AND NOT brood_frame=2 ORDER BY beehive_name")
    fun getBadBroodFrameBees(key: Long): LiveData<List<Beehive>>

    @Query("SELECT * FROM beehive_table WHERE group_id = :key AND NOT honey_frame=2 ORDER BY beehive_name")
    fun getBadHoneyFrameBees(key: Long): LiveData<List<Beehive>>

    @Query("SELECT * FROM (SELECT * FROM beehive_table WHERE group_id = :key) WHERE queen_bee_year < :year OR queen_bee_state<3 ORDER BY beehive_name")
    fun getBadQueenBees(key: Long, year: Long): LiveData<List<Beehive>>

    @Query("SELECT * FROM bee_group_table WHERE NOT group_name = '' ORDER BY group_name ASC")
    fun getAllGroups(): LiveData<List<BeeGroup>>

    @Query("SELECT * FROM (SELECT * FROM beehive_table WHERE group_id = :key) WHERE  nosema=1 OR ascosphaera_apis=10 ORDER BY beehive_name")
    fun getAllSickBeehives(key: Long): LiveData<List<Beehive>>

    @Query("SELECT COUNT(*) FROM beehive_table WHERE group_id=:groupkey AND beehive_population=:number")
    fun getCountPopulationBeehives(groupkey: Long, number: Int): Int?

    @Query("SELECT COUNT(*) FROM beehive_table WHERE group_id=:groupkey AND queen_bee_state=:number")
    fun getCountQueenbeeState(groupkey: Long, number: Int): Int?

    @Query("SELECT COUNT(*) FROM beehive_table WHERE group_id=:groupkey AND queen_bee_year=:number")
    fun getCountQueenBeeAge(groupkey: Long,number: Int): Int?

    @Query("SELECT COUNT(*) FROM (SELECT * FROM beehive_table WHERE group_id=:groupkey) WHERE queen_bee_year < :year OR queen_bee_state<3")
    fun getAllBadQueenBee(groupkey: Long, year: Int): Int?

    @Query("SELECT COUNT(*) FROM (SELECT * FROM beehive_table WHERE group_id=:groupkey) WHERE nosema=1 OR ascosphaera_apis=10")
    fun getCountSicksBees(groupkey: Long): Int?

    @Query("SELECT COUNT(*) FROM beehive_table WHERE group_id=:groupkey")
    fun getAllHive(groupkey: Long): Int?

    @Query("SELECT * FROM (SELECT * FROM beehive_table WHERE group_id=:groupkey) WHERE (beehive_population > 3 AND brood_frame > 2 AND queen_bee_year >= :year) OR swarming_queen_cells = 1 ORDER BY beehive_name")
    fun getSwarmingBees(groupkey: Long, year: Long): LiveData<List<Beehive>>

    @Query("SELECT COUNT(*) FROM (SELECT * FROM beehive_table WHERE group_id=:groupkey) WHERE (beehive_population > 3 AND brood_frame > 2 AND queen_bee_year >= :year) OR swarming_queen_cells = 1 ORDER BY beehive_name")
    fun getCountSwarmingBees(groupkey: Long, year: Long): Int?
}