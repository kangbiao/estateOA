package estate.controller;

import estate.service.BaseService;
import estate.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kangbiao on 15-10-20.
 *
 */
@RestController
@RequestMapping(value = "/picture")
public class PictureController
{
    @Autowired
    private PictureService pictureService;
    @Autowired
    private BaseService baseService;


}
