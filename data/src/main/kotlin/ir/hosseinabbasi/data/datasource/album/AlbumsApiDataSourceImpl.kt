package ir.hosseinabbasi.data.datasource.album

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import ir.hosseinabbasi.data.api.AlbumApi
import ir.hosseinabbasi.data.mapper.map
import ir.hosseinabbasi.domain.entity.Entity

/**
 * Created by Dr.jacky on 9/24/2018.
 */
/**
 * Album network data source implementation
 */
class AlbumsApiDataSourceImpl(private val api: AlbumApi) : AlbumsApiDataSource {

    /**
     * Get all of albums from network implementation
     */
    override fun getAlbums(page: Int, pageSize: Int): Single<List<Entity.Album>> =
            api.getAlbums(page, pageSize)
                    .map { item -> item.map { it.map() } }.subscribeOn(Schedulers.io())
}