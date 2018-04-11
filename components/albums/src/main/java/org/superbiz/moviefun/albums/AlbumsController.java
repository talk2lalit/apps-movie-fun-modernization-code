package org.superbiz.moviefun.albums;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumsController {

    private final AlbumsBean albumsBean;

    public AlbumsController(AlbumsBean albumsBean) {
        this.albumsBean = albumsBean;
    }

    @GetMapping
    public List<Album> index() {
        return albumsBean.getAlbums();
    }

    @GetMapping("/{albumId}")
    public Album details(@PathVariable long albumId) {
        return albumsBean.find(albumId);
    }

    @PostMapping
    public void addAlbum(@RequestBody Album album){
            albumsBean.addAlbum(album);
    }
}
