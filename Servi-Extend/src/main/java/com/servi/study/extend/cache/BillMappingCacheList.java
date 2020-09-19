package com.servi.study.extend.cache;

import com.servi.study.extend.cache.vo.BillMappingVO;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;


public class BillMappingCacheList extends ImagCacheAdapter<BillMappingVO> {

    private volatile static ICache<BillMappingVO> INSTANCE = null;

    private Set<BillMappingVO> cache = null;

    /**
     * ��õ�ǰvo��cache
     *
     * @return
     */
    public static ICache<BillMappingVO> getInstance() {

        if (INSTANCE == null) {
            synchronized (BillMappingCacheList.class) {
                if (INSTANCE == null) {
                    INSTANCE = new BillMappingCacheList();
                }
            }
        }
        return INSTANCE;
    }

    private BillMappingCacheList() {

        cache = new HashSet<BillMappingVO>();
    }

    @Override
    public BillMappingVO get(String condition) {

        if (StringUtils.isEmpty(condition) || this.isEmpty()) {
            return null;
        }

        BillMappingVO[] items = this.get();

        for (BillMappingVO vo : items) {
            return vo;
        }

        return null;
    }

    @Override
    public BillMappingVO[] get() {

        return this.cache.isEmpty() ? new BillMappingVO[0] : this.cache.toArray(new BillMappingVO[0]);
    }

    @Override
    public boolean add(BillMappingVO e) {

        return true;
        //return this.cache.add(new BillMappingCacheVO(e));
    }

    @Override
    public boolean addAll(BillMappingVO[] args) {

        if (ArrayUtils.isEmpty(args)) {
            return false;
        }

        for (BillMappingVO vo : args) {
            this.cache.add(new BillMappingCacheVO(vo));
        }
        return true;
    }

    @Override
    public boolean remove(BillMappingVO e) {

        return this.cache.remove(e);
    }

    @Override
    public boolean contains(BillMappingVO e) {

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

    private static class BillMappingCacheVO extends BillMappingVO {

        private static final long serialVersionUID = 1L;

        private BillMappingCacheVO(BillMappingVO vo) {


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
