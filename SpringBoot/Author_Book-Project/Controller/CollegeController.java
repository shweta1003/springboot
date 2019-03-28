package com.insert.table.db.collegeRepository;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import com.insert.table.db.collegeBean.College;
/**
 * @author vishal
 *
 */
@RestController
@RequestMapping
public class CollegeController
{
	
	@Autowired
	CollegeRepository collegeR;
	
	@GetMapping("/showCollege")
	public Iterable<College> getAll()
	{
		return collegeR.findAll();
	}

    @PostMapping(value="/insetCollege")
	public Iterable<College> getAllStudent(@RequestBody final College college)
	{
		collegeR.save(college);
		return collegeR.findAll(); 
	}

    @PutMapping("/insert/{cid}")
    public College updateCollege(@PathVariable Long cid, @Valid @RequestBody College postRequest) {
        return collegeR.findById(cid).map(college -> {
            college.setCname(postRequest.getCname());
            college.setCdep(postRequest.getCdep());
            return collegeR.save(college);
        }).orElseThrow(() -> new ResourceAccessException("cid " + cid + " not found"));
    }

}
