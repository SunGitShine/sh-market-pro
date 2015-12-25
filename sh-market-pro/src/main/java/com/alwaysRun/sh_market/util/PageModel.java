package com.alwaysRun.sh_market.util;

import java.io.Serializable;
import java.util.List;

/**
 * @author yudanxi
 *
 * @param <T>
 */
public class PageModel<T>  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4667391197782845813L;

	/**
     * 总记录数
     */
    private long totalRecords;

    /**
     * 总数据
     */
    private List<T> records;

    /**
     * 当前页码数
     */
    private long pageNo;

    /**
     * 每页显示条数
     */
    private long pageSize; 

    public long getTotalRecords() {
        return totalRecords;
    }

    /**
     * 总页码数
     *
     * @return
     */
    public long getTotalPage() {
    	if (pageNo == 0) {
            return 0;
        }
        return (totalRecords + pageSize - 1) / pageSize;
    }

    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getPageNo() {
        return pageNo;
    }

    public void setPageNo(long pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * 第一页
     *
     * @return
     */
    public long getTopPageNo() {
    	if (pageNo == 0) {
            return 0;
        }
        return 1;
    }

    /**
     * 上一页
     *
     * @return
     */
    public long getPreviousPageNo() {
    	if (pageNo == 0) {
            return 0;
        }
        if (pageNo <= 1) {
            return 1;
        }
        return pageNo - 1;
    }

    /**
     * 下一页
     *
     * @return
     */
    public long getNextPageNo() {
    	if (pageNo == 0) {
            return 0;
        }
        if (pageNo >= getTotalPage()) {
            return getTotalPage() == 0 ? 1 : getTotalPage();
        }
        return pageNo + 1;
    }

    /**
     * 最后一页
     *
     * @return
     */
    public long getBottomPageNo() {
    	if (pageNo == 0) {
            return 0;
        }
        return getTotalPage() == 0 ? 1 : getTotalPage();
    }
}
