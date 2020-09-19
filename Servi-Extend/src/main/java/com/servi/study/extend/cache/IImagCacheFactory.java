package com.servi.study.extend.cache;

import com.servi.study.extend.cache.vo.BaseFactoryVO;
import com.servi.study.extend.cache.vo.BillMappingVO;
import com.servi.study.extend.cache.vo.SuperVO;

import java.io.Serializable;

public class IImagCacheFactory {


    @SuppressWarnings("unchecked")
    public static <E extends Serializable> ICache<E> ICache(Class<? extends SuperVO> clazz) {

        if (clazz.isAssignableFrom(BaseFactoryVO.class)) {
            return (ICache<E>) BaseFactoryCacheList.getInstance();
        } else if (clazz.isAssignableFrom(BillMappingVO.class)) {
            return (ICache<E>) BillMappingCacheList.getInstance();
        }

        return null;
    }
}
