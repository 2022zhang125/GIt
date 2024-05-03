package com.hbsfdxwlxy.competition.service.impl;

import com.hbsfdxwlxy.competition.mapper.DMSDeptMapper;
import com.hbsfdxwlxy.competition.mapper.DMSUserMapper;
import com.hbsfdxwlxy.competition.pojo.Dept;
import com.hbsfdxwlxy.competition.utils.SqlSessionUtil;

import java.util.List;

/**
 * 部门实现类，去实现了我们的业务接口
 * @author BelieveSun
 * @version 1.0
 * @since 1.0
 */
public class DMSDeptServiceImpl extends DMSServiceImpl{
    DMSDeptMapper deptMapper = SqlSessionUtil.openSession().getMapper(DMSDeptMapper.class);

    /**
     * 打印部门列表方法
     * @return 返回所有的用户列表
     */
    @Override
    public List<Dept> doList() {
        List<Dept> deptList = deptMapper.selectDeptAll();
        return deptList;
    }

    /**
     * 用于添加部门
     * @param dept 待添加的部门
     * @return 是否添加成功
     */
    @Override
    public Boolean doAdd(Dept dept) {
        Boolean flag = false;
        int count = deptMapper.addDept(dept);
        if (count == 1) {
            flag = true;
        }
        return flag;
    }

    /**
     * 依据部门编号删除部门数据
     * @param deptno 部门编号
     * @return 是否删除成功
     */
    @Override
    public Boolean doDel(String deptno) {
        Boolean flag = false;
        int count = deptMapper.deleteByDeptno(deptno);
        if(count == 1){
            flag = true;
        }
        return flag;
    }

    /**
     * 用于修改部门信息
     * @param dept 待修改的部门对象
     * @return 是否修改成功
     */
    @Override
    public Boolean doEdit(Dept dept) {
        Boolean flag = false;
        int count = deptMapper.updateDeptByDeptno(dept);
        if(count == 1){
            flag = true;
        }
        return flag;
    }

    /**
     * 用于查看部门细节
     * @param deptno 待查看的部门对象
     * @return 部门对象
     */
    @Override
    public Dept doDetail(String deptno) {
        Dept dept = deptMapper.selectDeptByDeptno(deptno);
        return dept;
    }
}
