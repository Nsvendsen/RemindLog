package com.remindlog.services;

import com.remindlog.models.ShareGroup;
import com.remindlog.repositories.ShareGroupRepository;
import org.springframework.stereotype.Service;

@Service
public class ShareGroupServiceImpl implements ShareGroupService {

    private ShareGroupRepository shareGroupRepository;

    public ShareGroupServiceImpl(ShareGroupRepository shareGroupRepository) {
        this.shareGroupRepository = shareGroupRepository;
    }

    @Override
    public ShareGroup findShareGroupById(Long id) {
        return shareGroupRepository.getOne(id);
    }
}
