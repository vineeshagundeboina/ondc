<form action="searchApplication" method="post">
<input name="utf8" type="hidden" value="">
      <div class="container">
        <div class="form-row align-items-center">
          <div class="form-group col-sm">
            <label for="ref_no" class="col-form-label font-weight-bold">Ref No.</label>
            <input type="text" class="form-control form-control-sm" name="ref_no" id="ref_no" placeholder="Ref no.">
          </div>

          <div class="form-group col-sm">
            <label for="acc_name" class="col-form-label font-weight-bold">Account Name</label>
            <input type="text" class="form-control form-control-sm" name="acc_name" id="acc_name" placeholder="Account Name">
          </div>

          <div class="form-group col-sm">
            <label for="acc_no" class="col-form-label font-weight-bold">Account No.</label>
             <input type="text" class="form-control form-control-sm" name="acc_no" id="acc_no" placeholder="Account No.">
          </div>

          <div class="form-group col-sm">
            <label for="mobile_no" class="col-form-label font-weight-bold">Mobile No.</label>
             <input type="text" class="form-control form-control-sm" name="mobile" id="mobile" placeholder="Mobile No.">
          </div>
          <div class="form-group col-sm ">
            <label for="status" class="col-form-label font-weight-bold">Status</label>
              <select class="form-control form-control-sm select_width_auto" name="status" id="status">
              <option value="new">Pending With Branch</option>
               <option selected="" value="pending,modified">Pending With Final Approval</option>
              <option value="approved">Approved</option>
              <option value="rejected">Rejected</option>
            </select>
          </div>
          <button type="submit" class="btn btn-primary btn-block font-weight-bold">
            Search <i class="fa fa-search" aria-hidden="true"></i>
          </button>

        </div>
      </div>
</form>
