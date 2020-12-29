package com.example.oasisdemo.vo;

import java.util.HashMap;
import java.util.Map;

public class CocollaVO {
    /**
     * 合作者
     */
    private CollaboratorVO collaborator;

    /**
     * 间接合作次数
     */
    private int chance;

    public CollaboratorVO getCollaborator() {
        return collaborator;
    }

    public void setCollaborator(CollaboratorVO collaborator) {
        this.collaborator = collaborator;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    public CocollaVO(Map.Entry<CollaboratorVO,Integer> entry) {
        this.collaborator = entry.getKey();
        this.chance = entry.getValue();
    }
}
