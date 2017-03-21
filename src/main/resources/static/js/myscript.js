$(document).ready(function () {
    $("#switch-category-fields").on("click", function () {
            if ($(this).text() == "New Category") {
                $(this).text("List");
                $("#Category2").attr('type', 'text');
                $("#Category").hide();
            } else {
                $(this).text("Add");
                $("#Category2").attr('type', 'hidden');
                $("#Category").show();
            }
        }
    );
    $("#productForm").submit(function () {
      var parent= $('#switch-category-fields').parent();
        var valueToSubmit= parent.find('[type!="hidden"]').val();
      $('#category-hidden').val(valueToSubmit);
        return true;
    });
});
