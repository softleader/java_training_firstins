

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/helloworld")
public class HelloWorldServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public HelloWorldServlet() {
    super();
    System.out.println("0 construct 實例化");
  }

  @Override
  public void init(ServletConfig config) throws ServletException {
    System.out.println("1 init 首次Request前具有Config的初始化");
    super.init(config);
  }
  @Override
  public void init() throws ServletException {
    System.out.println("2 init 首次Request前的初始化");
    super.init();
  }
  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    System.out.println("3 request 收到servlet的request");
    super.service(req, res);
  }
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("4 request 轉為http的request");
    super.service(req, resp);
  }

  @Override
  public void destroy() {
    System.out.println("5 destroy 銷毀");
    super.destroy();
  }



  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
    request.getRequestDispatcher("WEB-INF/helloworld/helloworld.html").forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
