package studentapp;

import java.io.IOException;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;

public class StudentTagHandler extends TagSupport {
    private Student studentObj;

    public void setStudent(Student student) {
        this.studentObj = student;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            if (studentObj != null) {
                pageContext.getOut().print(studentObj.getName() + " studies " + studentObj.getCourse());
            }
        } catch (IOException err) {
            throw new JspException(err);
        }
        return SKIP_BODY;
    }
}
