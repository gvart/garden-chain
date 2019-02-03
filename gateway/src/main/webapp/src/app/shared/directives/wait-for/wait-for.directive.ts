import {ComponentFactory, ComponentFactoryResolver, ComponentRef, Directive, Input, TemplateRef, ViewContainerRef} from '@angular/core';
import {WaitForComponent} from './wait-for.component';

@Directive({
  selector: '[gcWaitFor]'
})
export class WaitForDirective {
  loadingFactory: ComponentFactory<WaitForComponent>;
  loadingComponent: ComponentRef<WaitForComponent>;

  @Input()
  set gcWaitFor(hasResult: any) {
    this.vcRef.clear();

    if (!hasResult) {
      // create and embed an instance of the loading component
      this.loadingComponent = this.vcRef.createComponent(this.loadingFactory);
    } else {
      // embed the contents of the host template
      this.vcRef.createEmbeddedView(this.templateRef);
    }
  }

  constructor(private templateRef: TemplateRef<any>,
              private vcRef: ViewContainerRef,
              private componentFactoryResolver: ComponentFactoryResolver) {
    // Create resolver for loading component
    this.loadingFactory = this.componentFactoryResolver.resolveComponentFactory(WaitForComponent);
  }
}
