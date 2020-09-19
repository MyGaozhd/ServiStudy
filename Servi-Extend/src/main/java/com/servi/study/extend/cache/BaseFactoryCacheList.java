
package com.servi.study.extend.cache;

import com.servi.study.extend.cache.vo.BaseFactoryVO;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

public class BaseFactoryCacheList extends ImagCacheAdapter<BaseFactoryVO> {

    private volatile static ICache<BaseFactoryVO> INSTANCE = null;

    private Set<BaseFactoryVO> cache = null;

    public static ICache<BaseFactoryVO> getInstance() {

        if (INSTANCE == null) {
            synchronized (BaseFactoryCacheList.class) {
                if (INSTANCE == null) {
                    INSTANCE = new BaseFactoryCacheList();
                }
            }
        }
        return INSTANCE;
    }

    private BaseFactoryCacheList() {

        cache = new HashSet<BaseFactoryVO>();
    }

    @Override
    public BaseFactoryVO get(String condition) {

        if (StringUtils.isEmpty(condition) || this.isEmpty()) {
            return null;
        }

        BaseFactoryVO[] items = this.get();
        for (BaseFactoryVO factory : items) {
            return factory;
        }
        return null;
    }

    @Override
    public BaseFactoryVO[] get() {

        return this.cache.isEmpty() ? new BaseFactoryVO[0] : this.cache.toArray(new BaseFactoryVO[0]);
    }

    @Override
    public boolean add(BaseFactoryVO e) {

        return true;
        //return this.cache.add(new BaseFactoryCacheVO(e));
    }

    @Override
    public boolean addAll(BaseFactoryVO[] args) {

        if (ArrayUtils.isEmpty(args)) {
            return false;
        }

        for (BaseFactoryVO vo : args) {
            this.cache.add(new BaseFactoryCacheVO(vo));
        }
        return true;
    }

    @Override
    public boolean remove(BaseFactoryVO e) {

        return this.cache.remove(e);
    }

    @Override
    public boolean contains(BaseFactoryVO e) {

        return this.cache.contains(e);
    }

    @Override
    public int size() {

        return this.cache.size();
    }

    @Override
    public boolean isEmpty() {

        return this.cache.isEmpty();
    }

    @Override
    public void clear() {

        this.cache.clear();
    }

    private static class BaseFactoryCacheVO extends BaseFactoryVO {

        private static final long serialVersionUID = 1L;

        private BaseFactoryCacheVO(BaseFactoryVO vo) {

        }

        @Override
        public int hashCode() {

            return super.hashCode();
        }

        @Override
        public boolean equals(Object vo) {
            return true;
        }
    }
}
