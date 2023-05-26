<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<c:if test="${Username == null}">
<a href="#" class="nav-link text-white">
                    <svg class="bi d-block mx-auto mb-1" width="24" height="24"><use xlink:href="#people-circle"></use></svg>
                    <div id="userEnter" class="text-end">
                        <a href="Log" type="submit" class="btn btn-light text-dark me-2">Login</a>
                        <a id="button-2" href="Reg" type="submit" class="btn btn-primary">Sign-up</a>
                      </div>
                  </a>
</c:if>

<c:if test="${Username !=null}">
<c:if test="${Username =='admin'}">
<a href="#" class="nav-link text-white">
                    <svg class="bi d-block mx-auto mb-1" width="24" height="24"><use xlink:href="#people-circle"></use></svg>
                    <div id="userEnter" class="text-end">
                        <a href="Order24" type="submit" class="btn btn-light text-dark me-2">WORK</a>
                        <a id="button-2" href="Reg" type="submit" class="btn btn-primary">EXIT</a>
                      </div>
                      <div>${Username}</div>
 </a>
</c:if>
<c:if test="${Username !='admin'}">
<a href="#" class="nav-link text-white">
                    <svg class="bi d-block mx-auto mb-1" width="24" height="24"><use xlink:href="#people-circle"></use></svg>
                    <div id="userEnter" class="text-end">
                        <a href="Order24" type="submit" class="btn btn-light text-dark me-2">Order History</a>
                        <a id="button-2" href="Reg" type="submit" class="btn btn-primary">EXIT</a>
                      </div>
                      <div>${Username}</div>
 </a>
</c:if>
</c:if>