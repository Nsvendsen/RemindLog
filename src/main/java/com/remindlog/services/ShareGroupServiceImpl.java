package com.remindlog.services;

import com.remindlog.repositories.ShareGroupRepository;
import org.springframework.stereotype.Service;

@Service
public class ShareGroupServiceImpl implements ShareGroupService {

    private ShareGroupRepository shareGroupRepository;

    public ShareGroupServiceImpl(ShareGroupRepository shareGroupRepository) {
        this.shareGroupRepository = shareGroupRepository;
    }
}
